package PresentationLayer.Panels;

import ApplicationLayer.*;
import DomainModelLayer.*;
import PresentationLayer.Controls.ControlNames;
import PresentationLayer.EventHandlers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageWatched extends JPanel  implements SyncManager{

    private JComboBox accounts, profiles, watched;


    public ManageWatched() {
        setLayout(new BorderLayout());

        add(ManagePanelBase.InitializeButtonPane(
                new lForCreateWatched(this),
                new lForUpdateWatched(this),
                new lForDeleteWatched(this)), BorderLayout.SOUTH);

        add(createContentPanel(), BorderLayout.NORTH);
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 0, 10));
        JLabel manageLabel = new JLabel(ControlNames.MANAGE_LABEL + ControlNames.TAB_PROFILES);
        panel.add(manageLabel);

        accounts = new JComboBox<>();
        profiles = new JComboBox<>();
        watched = new JComboBox<>();

        accounts.addActionListener(new lForProfileBox(accounts, profiles));
        panel.add(accounts);

        profiles.addActionListener(new lForWatchedBox(profiles, watched));
        panel.add(profiles);
        panel.add(watched);

        updateCombobox();

        return panel;
    }

    public void handleDelete(){
        int dialogResult = JOptionPane.showConfirmDialog(null, ControlNames.CONFIRM_REMOVE, ControlNames.CONFIRM_TITLE_WARNING, JOptionPane.YES_NO_OPTION);

        Watched w = (Watched) getSelectedObject();
        if(w == null) {
            JOptionPane.showMessageDialog(null, "Select a watched first", ControlNames.CONFIRM_TITLE_WARNING, JOptionPane.OK_OPTION);

            return;
        }
        System.out.println(w.getId());

        WatchedManager watchedManager = new WatchedManager();
        watchedManager.deleteWatched(w, (Profile)profiles.getSelectedItem());
        updateCombobox();
    }

    public void updateCombobox() {
        accounts.setModel(new DefaultComboBoxModel(new AccountManager().getAllAccounts().toArray()));
        profiles.setModel(new DefaultComboBoxModel((new ProfileManager().getProfilesFromOwner((Account) accounts.getSelectedItem()).toArray())));

        if (profiles.getSelectedItem() != null) {
            Profile profile = (Profile) profiles.getSelectedItem();
            // Add serie - episode - movie to the boox, instead of their id's
            watched.setModel(new DefaultComboBoxModel(new WatchedManager().getAllWatchedForProfile(profile).toArray()));
        }
    }

    public Watched getSelectedObject() {
        return (Watched) watched.getSelectedItem();
    }

    public void ManageWatched(boolean update) {
        if (profiles.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, ControlNames.CONFIRM_SELECT_PROFILE_WATCHED, ControlNames.CONFIRM_TITLE_WARNING, JOptionPane.OK_OPTION);
            return;
        }

        //Todo, make jcomponent array a list, and convert it back in the panel segment.
        // Do this so we can have a non-final element array

        JComponent[] inputs = new JComponent[8];
        JComboBox movieOrSerie = new JComboBox();
        JComboBox SerieOrMovieBox = new JComboBox();
        JComboBox EpisodeBox = new JComboBox();

        if (update) {
            //resolve this;
            DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
            defaultComboBoxModel.addElement("Movie");
            defaultComboBoxModel.addElement("Serie");
            movieOrSerie.setModel(defaultComboBoxModel);


            //We need to have the difference between the two, how do we segmentate this?

            Watched c = (Watched) watched.getSelectedItem();


            MovieManager movieManager = new MovieManager();
            Movie m = movieManager.getMovieById(c.getProgramId());

            if (m == null) {
                EpisodeManager episodeManager = new EpisodeManager();
                Episode e = episodeManager.getEpisodeById(c.getProgramId());

                if (e == null) {
                    Serie serie = new SerieManager().getSerieById(c.getProgramId());
                    if (serie != null)
                        movieOrSerie.setSelectedIndex(1);

                    SerieOrMovieBox.setSelectedItem(serie);
                }
            } else {
                movieOrSerie.setSelectedIndex(0);
            }


        } else {
            DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
            defaultComboBoxModel.addElement("Movie");
            defaultComboBoxModel.addElement("Serie");
            movieOrSerie.setModel(defaultComboBoxModel);


        }

        //Move to Class and use interface to use loos coupling
        movieOrSerie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (movieOrSerie.getSelectedItem().equals("Movie")) {
                    MovieManager movieManager = new MovieManager();
                    SerieOrMovieBox.setModel(new DefaultComboBoxModel(movieManager.getAllMovies().toArray()));

                } else {
                    SerieManager serieManager = new SerieManager();
                    SerieOrMovieBox.setModel(new DefaultComboBoxModel(serieManager.getAllSeries().toArray()));

                }
            }
        });

        SerieOrMovieBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (movieOrSerie.getSelectedItem().equals("Movie")) {
                    //remove that episode box;
                } else {
                    EpisodeManager episodeManager = new EpisodeManager();
                    EpisodeBox.setModel(new DefaultComboBoxModel(episodeManager.getAllEpisodesBySeriesId(((Serie) SerieOrMovieBox.getSelectedItem()).getId()).toArray()));
                }
            }
        });

        //Trigger set.
        if (!update) {
            if (movieOrSerie.getItemCount() > 0)
                movieOrSerie.setSelectedIndex(0);
        }

        JSlider jSlider = new JSlider();
        jSlider.setPaintTicks(true);
        jSlider.setMajorTickSpacing(20);
        jSlider.setMinorTickSpacing(5);
        jSlider.setSnapToTicks(true);
        jSlider.setPaintLabels(true);


        inputs = new JComponent[]{
                new JLabel("Select movie or serie first"),
                movieOrSerie,
                new JLabel("Selected the watched {PLACEHOLDER}"),
                SerieOrMovieBox,
                new JLabel("Select episode"),
                EpisodeBox,
                new JLabel("Watched percentage"),
                jSlider
        };

        //Remove
        //inputs[3] = null;


        int result = JOptionPane.showConfirmDialog(null, inputs, ControlNames.CONFIRM_FILL_ALL_FIELDS, JOptionPane.DEFAULT_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            if (update) {
                //accountManager.updateAccount(parsedObj, (Account) accounts.getSelectedItem());
            } else {
                WatchedManager watchedManager = new WatchedManager();

                if(((Episode)EpisodeBox.getSelectedItem()) == null) {
                    watchedManager.addWatched(new Watched(0, jSlider.getValue(), ((Episode) EpisodeBox.getSelectedItem()).getId(), ((Profile) profiles.getSelectedItem()).getId()));
                    updateCombobox();
                }
                else{
                    watchedManager.addWatched(new Watched(0, jSlider.getValue(), ((Movie) SerieOrMovieBox.getSelectedItem()).getId(), ((Profile) profiles.getSelectedItem()).getId()));
                }
            }

        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }

    @Override
    public void update() {
        updateCombobox();
    }
}

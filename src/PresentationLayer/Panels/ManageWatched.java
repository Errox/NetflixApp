package PresentationLayer.Panels;

import ApplicationLayer.*;
import DomainModelLayer.*;
import PresentationLayer.Controls.ControlNames;
import PresentationLayer.EventHandlers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageWatched extends JPanel implements SyncManager {

    private JComboBox accounts, profiles, watchedComboBox;


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
        watchedComboBox = new JComboBox<>();

        accounts.addActionListener(new lForProfileBox(accounts, profiles));
        panel.add(accounts);

        profiles.addActionListener(new lForWatchedBox(profiles, watchedComboBox));
        panel.add(profiles);
        panel.add(watchedComboBox);

        updateCombobox();

        return panel;
    }

    public void handleDelete() {
        int dialogResult = JOptionPane.showConfirmDialog(null, ControlNames.CONFIRM_REMOVE, ControlNames.CONFIRM_TITLE_WARNING, JOptionPane.YES_NO_OPTION);

        Watched w = (Watched) getSelectedObject();
        if (w == null) {
            JOptionPane.showMessageDialog(null, "Select a watchedComboBox first", ControlNames.CONFIRM_TITLE_WARNING, JOptionPane.OK_OPTION);

            return;
        }

        if (dialogResult == JOptionPane.YES_OPTION) {
            WatchedManager watchedManager = new WatchedManager();
            watchedManager.deleteWatched(w);
            updateCombobox();
        }
    }

    public void updateCombobox() {
        accounts.setModel(new DefaultComboBoxModel(new AccountManager().getAllAccounts().toArray()));
        profiles.setModel(new DefaultComboBoxModel((new ProfileManager().getProfilesFromOwner((Account) accounts.getSelectedItem()).toArray())));

        if (profiles.getSelectedItem() != null) {
            Profile profile = (Profile) profiles.getSelectedItem();
            // Add serie - episode - movie to the boox, instead of their id's
            watchedComboBox.setModel(new DefaultComboBoxModel(new WatchedManager().getAllWatchedForProfile(profile).toArray()));
        }
    }

    public Watched getSelectedObject() {
        return (Watched) watchedComboBox.getSelectedItem();
    }

    public void ManageWatched(boolean update) {
        if (profiles.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, ControlNames.CONFIRM_SELECT_PROFILE_WATCHED, ControlNames.CONFIRM_TITLE_WARNING, JOptionPane.OK_OPTION);
            return;
        }
        // Watched watchedComboBox;
        //Todo, make jcomponent array a list, and convert it back in the panel segment.
        // Do this so we can have a non-final element array
        Watched watched = null;
        JComponent[] inputs = new JComponent[8];
        JComboBox movieOrSerie = new JComboBox();
        JComboBox SerieOrMovieBox = new JComboBox();
        JLabel episodesLabel = new JLabel("Select episode");
        JComboBox EpisodeBox = new JComboBox();

        JSlider jSlider = new JSlider();
        jSlider.setPaintTicks(true);
        jSlider.setMajorTickSpacing(20);
        jSlider.setMinorTickSpacing(5);
        jSlider.setSnapToTicks(true);
        jSlider.setPaintLabels(true);

        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        defaultComboBoxModel.addElement("Serie");
        defaultComboBoxModel.addElement("Movie");
        movieOrSerie.setModel(defaultComboBoxModel);

        movieOrSerie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (movieOrSerie.getSelectedItem().equals("Movie")) {
                    MovieManager movieManager = new MovieManager();
                    SerieOrMovieBox.setModel(new DefaultComboBoxModel(movieManager.getAllMovies().toArray()));
                    EpisodeBox.setVisible(false);
                    episodesLabel.setVisible(false);

                } else {
                    SerieManager serieManager = new SerieManager();
                    SerieOrMovieBox.setModel(new DefaultComboBoxModel(serieManager.getAllSeries().toArray()));
                    EpisodeBox.setVisible(true);
                    episodesLabel.setVisible(true);

                }
            }
        });

        SerieOrMovieBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!movieOrSerie.getSelectedItem().equals("Movie")) {
                    EpisodeManager episodeManager = new EpisodeManager();
                    EpisodeBox.setModel(new DefaultComboBoxModel(episodeManager.getAllEpisodesBySeriesId(((Serie) SerieOrMovieBox.getSelectedItem()).getId()).toArray()));
                }
            }
        });

        if (update) {
            watched = (Watched) watchedComboBox.getSelectedItem();
            jSlider.setValue(watched.getPercentage());

            MovieManager movieManager = new MovieManager();
            Movie m = movieManager.getMovieByProgramId(watched.getProgramId());

            if (m == null) {
                EpisodeManager episodeManager = new EpisodeManager();
                Episode e = episodeManager.getEpisodeByProgramId(watched.getProgramId());
                movieOrSerie.setSelectedItem("Serie");

                if (e != null) {
                    Serie serie = new SerieManager().getSerieById(e.getSerieId());
                    if (serie != null) {
                        ComboBoxModel model = SerieOrMovieBox.getModel();
                        int size = model.getSize();
                        for (int i = 0; i < size; i++) {
                            Serie element = (Serie) model.getElementAt(i);
                            if (element.getId() == serie.getId()) {
                                SerieOrMovieBox.setSelectedItem(element);
                            }
                        }
                        ComboBoxModel model2 = EpisodeBox.getModel();
                        int size2 = model2.getSize();
                        for (int i = 0; i < size2; i++) {
                            Episode element = (Episode) model2.getElementAt(i);
                            if (element.getId() == e.getId()) {
                                EpisodeBox.setSelectedItem(e);
                            }
                        }
                    }
                }
            }
            movieOrSerie.setEnabled(false);
            SerieOrMovieBox.setEnabled(false);
            EpisodeBox.setEnabled(false);
        } else {
            movieOrSerie.setSelectedItem("Movie");
        }
        //Move to Class and use interface to use loos coupling


        //Trigger set.
        if (!update) {
            if (movieOrSerie.getItemCount() > 0)
                movieOrSerie.setSelectedIndex(0);
        }

        inputs = new JComponent[]{
                new JLabel("Select movie or serie first"),
                movieOrSerie,
                new JLabel("Selected the watchedComboBox media"),
                SerieOrMovieBox,
                episodesLabel,
                EpisodeBox,
                new JLabel("Watched percentage"),
                jSlider
        };

        //Remove
        //inputs[3] = null;


        int result = JOptionPane.showConfirmDialog(null, inputs, ControlNames.CONFIRM_FILL_ALL_FIELDS, JOptionPane.DEFAULT_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            WatchedManager watchedManager = new WatchedManager();
            if (update) {
                if (watched != null) {
                    watchedManager.updateWatched(new Watched(watched.getId(), jSlider.getValue(), watched.getProgramId(), watched.getProfileId()), watched);
                }

            } else {

                if (SerieOrMovieBox.getSelectedItem() instanceof Movie) {
                    watchedManager.addWatched(new Watched(0, jSlider.getValue(), ((Movie) SerieOrMovieBox.getSelectedItem()).getProgramId(), ((Profile) profiles.getSelectedItem()).getId()));
                } else if (((Episode) EpisodeBox.getSelectedItem()) != null) {
                    watchedManager.addWatched(new Watched(0, jSlider.getValue(), ((Episode) EpisodeBox.getSelectedItem()).getProgramId(), ((Profile) profiles.getSelectedItem()).getId()));

                }
            }
            updateCombobox();
        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }

    @Override
    public void update() {
        updateCombobox();
    }
}

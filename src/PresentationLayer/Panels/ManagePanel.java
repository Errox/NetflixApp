package PresentationLayer.Panels;

import ApplicationLayer.*;
import DomainModelLayer.*;
import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Controls.JCalendar;
import PresentationLayer.Controls.JMaxLengthTextBox;
import PresentationLayer.Controls.ManageType;
import PresentationLayer.EventHandlers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManagePanel extends JPanel {

    //todo; split to three seperate panels.

    private ManageType manageType;
    private JComboBox accounts, profiles, watched;

    public ManagePanel(ManageType manageType) {
        this.manageType = manageType;

        setLayout(new BorderLayout());

        add(createButtonPanel(), BorderLayout.SOUTH);
        add(createContentPanel(), BorderLayout.NORTH);
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 0, 10));

        JLabel manageLabel = new JLabel(ControlNames.MANAGE_LABEL + manageType.toString().toLowerCase());
        panel.add(manageLabel);

        //JLabel underManage = new JLabel("Selecteer een " + manageType.toString().toLowerCase() + " en druk onderaan de knop om te een nieuwe aan te maken, bijwerken of verwijderen");
        //  panel.add(underManage);

        if (manageType == ManageType.ACCOUNT) {
            accounts = new JComboBox<>();
            panel.add(accounts);
        } else if (manageType == ManageType.PROFILE) {
            profiles = new JComboBox<>();

            accounts = new JComboBox<>();
            accounts.addActionListener(new lForProfileBox(accounts, profiles));
            panel.add(accounts);
            panel.add(profiles);

        } else if (manageType == ManageType.WATCHED) {

            accounts = new JComboBox<>();
            profiles = new JComboBox<>();
            watched = new JComboBox<>();

            accounts.addActionListener(new lForProfileBox(accounts, profiles));
            panel.add(accounts);

            profiles.addActionListener(new lForWatchedBox(profiles, watched));
            panel.add(profiles);
            panel.add(watched);
        }

        updateCombobox();

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JButton createButton = new JButton("Create");
        createButton.setName(ControlNames.MANAGE_BUTTON_CREATE);
        panel.add(createButton);

        JButton updateButton = new JButton("Update");
        updateButton.setName(ControlNames.MANAGE_BUTTON_UPDATE);

        panel.add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setName(ControlNames.MANAGE_BUTTON_DELETE);
        panel.add(deleteButton);

        createButton.addActionListener(new lForCreate(this));
        updateButton.addActionListener(new lForUpdate(this));
        deleteButton.addActionListener(new lForDelete(this));

        return panel;
    }

    public Profile getSelectedProfile(){
        if(profiles.getSelectedItem() != null){
            return (Profile)profiles.getSelectedItem();
        }
        else{
            return null;
        }

    }

    public void updateCombobox() {
        if (manageType == ManageType.ACCOUNT) {
            accounts.setModel(new DefaultComboBoxModel(new AccountManager().getAllAccounts().toArray()));
        } else if (manageType == ManageType.PROFILE) {
            accounts.setModel(new DefaultComboBoxModel(new AccountManager().getAllAccounts().toArray()));
            profiles.setModel(new DefaultComboBoxModel((new ProfileManager().getProfilesFromOwner((Account) accounts.getSelectedItem()).toArray())));
        } else if (manageType == ManageType.WATCHED) {
            accounts.setModel(new DefaultComboBoxModel(new AccountManager().getAllAccounts().toArray()));
            profiles.setModel(new DefaultComboBoxModel((new ProfileManager().getProfilesFromOwner((Account) accounts.getSelectedItem()).toArray())));

            if (profiles.getSelectedItem() != null) {
                Profile profile = (Profile) profiles.getSelectedItem();
                // Add serie - episode - movie to the boox, instead of their id's
                watched.setModel(new DefaultComboBoxModel(new WatchedManager().getAllWatchedForProfile(profile).toArray()));
            }
        }
    }

    public Object getSelectedObject() {
        if (manageType == ManageType.ACCOUNT) {
            return accounts.getSelectedItem();
        } else if (manageType == ManageType.PROFILE) {
            return profiles.getSelectedItem();
        } else if (manageType == ManageType.WATCHED) {
            return watched.getSelectedItem();
        }

        return null;
    }

    public void ManageProfile(boolean update) {
        if (update && profiles.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, ControlNames.CONFIRM_SELECT_PROFILE, ControlNames.CONFIRM_TITLE_WARNING, JOptionPane.OK_OPTION);
            return;
        }

        ProfileManager profileManager = new ProfileManager();

        JMaxLengthTextBox fullName = new JMaxLengthTextBox(50);
        JCalendar birthDate = new JCalendar(10);


        Profile profile = null;
        if (((Profile) getSelectedObject()) != null)
            profile = profileManager.getProfileById(((Profile) getSelectedObject()).getId());

        if (update) {
            birthDate.setDate(profile.getBirthDate());
            fullName.setText(profile.getName());
        }

        final JComponent[] inputs = new JComponent[]{
                new JLabel(ControlNames.FULL_NAME),
                fullName,
                new JLabel(ControlNames.BIRTHDAY),
                birthDate
        };

        int result = JOptionPane.showConfirmDialog(null, inputs, ControlNames.CONFIRM_FILL_ALL_FIELDS, JOptionPane.DEFAULT_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            //Insert
            //FIX DATE TIME FROM CUSTOM BOX AND ITS VALUE WITH DELETE KEY


            if (update) {
                System.out.println(profileManager.getProfileCount((Account) accounts.getSelectedItem()));
                profileManager.updateProfile(new Profile(0, fullName.getText(), birthDate.getDateValue(), ((Account) accounts.getSelectedItem()).getId()), (Profile) profiles.getSelectedItem());
                updateCombobox();
                System.out.println(birthDate.getDateValue());


            } else {
                int p = profileManager.getProfileCount((Account) accounts.getSelectedItem());
                if (p <= 4) {
                    System.out.println(profileManager.getProfileCount((Account) accounts.getSelectedItem()));
                    profileManager.addProfile(new Profile(0, fullName.getText(), birthDate.getDateValue(), ((Account) accounts.getSelectedItem()).getId()));
                    updateCombobox();
                    System.out.println(birthDate.getDateValue());

                } else
                    JOptionPane.showMessageDialog(this, ControlNames.MAX_ACCOUNT_MESSAGE, ControlNames.CONFIRM_TITLE_WARNING, JOptionPane.ERROR_MESSAGE);
            }


        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }

    public void ManageAccount(boolean update) {
        AccountManager accountManager = new AccountManager();

        JMaxLengthTextBox fullName = new JMaxLengthTextBox(50);
        JMaxLengthTextBox streetName = new JMaxLengthTextBox(50);
        JMaxLengthTextBox postalCode = new JMaxLengthTextBox(6);
        JMaxLengthTextBox houseNumber = new JMaxLengthTextBox(5);
        JMaxLengthTextBox place = new JMaxLengthTextBox(50);
        JCalendar birthday = new JCalendar(10);

        if (update && accounts.getSelectedItem() != null) {
            Account account = accountManager.getAccountById(((Account) accounts.getSelectedItem()).getId());

            fullName.setText(account.getName());
            streetName.setText(account.getStreetName());
            postalCode.setText(account.getPostalCode());
            houseNumber.setText(account.getHouseNumber());
            place.setText(account.getPlace());

            ProfileManager pfm
                     = new ProfileManager();
            Profile f = pfm.getProfileById(((Account)getSelectedObject()).getId());
                birthday.setText(f.getBirthDate().toString());
        }

        ArrayList<JComponent> jComponents = new ArrayList<JComponent>();

        jComponents.add(new JLabel(ControlNames.FULL_NAME));
        jComponents.add(fullName);
        jComponents.add(new JLabel(ControlNames.STREET_NAME));
        jComponents.add(streetName);
        jComponents.add(  new JLabel(ControlNames.POSTAL_CODE));
        jComponents.add( postalCode);
        jComponents.add(new JLabel(ControlNames.HOUSE_NUMBER));
        jComponents.add(houseNumber);
        jComponents.add( new JLabel(ControlNames.PLACE));
        jComponents.add(place);
        jComponents.add(new JLabel(ControlNames.BIRTHDAY));
        jComponents.add(birthday);

        if(update){

            int size = jComponents.size();
           //Remove the Birthday elements
           for(int i = 1; i < 3; i++){
                jComponents.remove(size-i);
          }
        }

        int result = JOptionPane.showConfirmDialog(null, jComponents.toArray(), ControlNames.CONFIRM_FILL_ALL_FIELDS, JOptionPane.DEFAULT_OPTION);

        if (result == JOptionPane.OK_OPTION) {

            Account parsedObj = new Account(0, fullName.getText(), streetName.getText(), postalCode.getText(), houseNumber.getText(), place.getText());

            if (update)
                accountManager.updateAccount(parsedObj, (Account) accounts.getSelectedItem());
            else {
                ProfileManager pfm = new ProfileManager();
                int id = accountManager.addAccount(parsedObj);

                pfm.addProfile(new Profile(0, fullName.getText(), birthday.getDateValue(), id));
            }

            updateCombobox();

            accounts.setSelectedItem(parsedObj);

        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
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
                watchedManager.addWatched(new Watched(0, jSlider.getValue(), ((Episode) EpisodeBox.getSelectedItem()).getId(), ((Profile) profiles.getSelectedItem()).getId()));
                updateCombobox();
            }

        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }

    public ManageType getManageType() {
        return manageType;
    }
}

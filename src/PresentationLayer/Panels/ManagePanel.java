package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.ProfileManager;
import ApplicationLayer.WatchedManager;
import DomainModelLayer.Account;
import DomainModelLayer.Profile;
import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Controls.JCalendar;
import PresentationLayer.Controls.JMaxLengthTextBox;
import PresentationLayer.Controls.ManageType;
import PresentationLayer.EventHandlers.*;

import javax.swing.*;
import java.awt.*;

public class ManagePanel extends JPanel {

    //todo; split to three seperate panels.
    //Les code.
    
    private ManageType manageType;
    private JComboBox accounts, profiles, watched;

    public ManagePanel(ManageType manageType) {
        this.manageType = manageType;

        setLayout(new BorderLayout());

        add(createButtonPanel(), BorderLayout.SOUTH);
        add(createContentPanel(), BorderLayout.NORTH);
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1));

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

            profiles = new JComboBox<>();

            accounts = new JComboBox<>();
            accounts.addActionListener(new lForProfileBox(accounts, profiles));
            panel.add(accounts);

            watched = new JComboBox<>();

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
        if( update && profiles.getSelectedItem() == null) {
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
            birthDate.setText(profile.getBirthDate().toString());
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

            //Implement Update <<<<  MAX 5 PROFILE, AND MIN 1

            //Insert
            //FIX DATE TIME FROM CUSTOM BOX AND ITS VALUE WITH DELETE KEY


            if (update) {
                System.out.println(profileManager.getProfileCount((Account) accounts.getSelectedItem()));
                profileManager.updateProfile(new Profile(0, fullName.getText(), birthDate.getValue(), ((Account) accounts.getSelectedItem()).getId()), (Profile) profiles.getSelectedItem());
                updateCombobox();
                System.out.println(birthDate.getValue());


            } else {
                int p = profileManager.getProfileCount((Account) accounts.getSelectedItem());
                if ( p <= 4 ) {
                    System.out.println(profileManager.getProfileCount((Account) accounts.getSelectedItem()));
                    profileManager.addProfile(new Profile(0, fullName.getText(), birthDate.getValue(), ((Account) accounts.getSelectedItem()).getId()));
                    updateCombobox();
                    System.out.println(birthDate.getValue());

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

        }

        final JComponent[] inputs = new JComponent[]{
                new JLabel(ControlNames.FULL_NAME),
                fullName,
                new JLabel(ControlNames.STREET_NAME),
                streetName,
                new JLabel(ControlNames.POSTAL_CODE),
                postalCode,
                new JLabel(ControlNames.HOUSE_NUMBER),
                houseNumber,
                new JLabel(ControlNames.PLACE),
                place,
                new JLabel(ControlNames.BIRTHDAY),
                birthday
        };

        int result = JOptionPane.showConfirmDialog(null, inputs, ControlNames.CONFIRM_FILL_ALL_FIELDS, JOptionPane.DEFAULT_OPTION);

        if (result == JOptionPane.OK_OPTION) {

            Account parsedObj = new Account(0, fullName.getText(), streetName.getText(), postalCode.getText(), houseNumber.getText(), place.getText());

            if (update)
                accountManager.updateAccount(parsedObj, (Account) accounts.getSelectedItem());
            else {
                ProfileManager pfm = new ProfileManager();
                int id = accountManager.addAccount(parsedObj);

                pfm.addProfile(new Profile(0, fullName.getText(), birthday.getValue() , id));
            }

            updateCombobox();

            accounts.setSelectedItem(parsedObj);

        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }

    public void ManageWatched() {
        if(profiles.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, ControlNames.CONFIRM_SELECT_PROFILE_WATCHED, ControlNames.CONFIRM_TITLE_WARNING, JOptionPane.OK_OPTION);
            return;
        }

        WatchedManager watchedManager = new WatchedManager();

        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JPasswordField password = new JPasswordField();


        final JComponent[] inputs = new JComponent[]{
                new JLabel("First"),
                firstName,
                new JLabel("Last"),
                lastName,
                new JLabel("Password"),
                password
        };

        int result = JOptionPane.showConfirmDialog(null, inputs, ControlNames.CONFIRM_FILL_ALL_FIELDS, JOptionPane.DEFAULT_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            System.out.println("You entered " +
                    firstName.getText() + ", " +
                    lastName.getText() + ", " +
                    password.getPassword());
        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }

    public ManageType getManageType() {
        return manageType;
    }
}

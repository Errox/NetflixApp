package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.ProfileManager;
import ApplicationLayer.WatchedManager;
import DomainModelLayer.Account;
import DomainModelLayer.Profile;
import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Controls.JCalendar;
import PresentationLayer.Controls.ManageType;
import PresentationLayer.EventHandlers.*;

import javax.swing.*;
import java.awt.*;

public class ManagePanel extends JPanel {

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

        JLabel manageLabel = new JLabel("Managing " + manageType.toString().toLowerCase());
        panel.add(manageLabel);

        JLabel underManage = new JLabel("Selecteer een " + manageType.toString().toLowerCase() + " en druk onderaan de knop om te een nieuwe aan te maken, bijwerken of verwijderen");
        panel.add(underManage);

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
        ProfileManager profileManager = new ProfileManager();

        JTextField fullName = new JTextField();
        JCalendar birthDate = new JCalendar(10);


        Profile profile = null;
        if (((Profile) getSelectedObject()) != null)
            profile = profileManager.getProfileById(((Profile) getSelectedObject()).getId());

        if (update) {
            birthDate.setText(profile.getBirthDate().toString());
            fullName.setText(profile.getName());
        }

        final JComponent[] inputs = new JComponent[]{
                new JLabel("FullName"),
                fullName,
                new JLabel("Birthdate (dd-mm-yyyy)"),
                birthDate
        };

        int result = JOptionPane.showConfirmDialog(null, inputs, "Fill in the fields", JOptionPane.DEFAULT_OPTION);

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
                if (profileManager.getProfileCount((Account) accounts.getSelectedItem()) <= 4) {
                    System.out.println(profileManager.getProfileCount((Account) accounts.getSelectedItem()));
                    profileManager.addProfile(new Profile(0, fullName.getText(), birthDate.getValue(), ((Account) accounts.getSelectedItem()).getId()));
                    updateCombobox();
                    System.out.println(birthDate.getValue());

                } else
                    JOptionPane.showMessageDialog(this, "Een account mag maximaal 5 profielen bevatten", "Error", JOptionPane.ERROR_MESSAGE);
            }


        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }

    public void ManageAccount(boolean update) {
        AccountManager accountManager = new AccountManager();

        JTextField fullName = new JTextField("", 8);
        JTextField streetName = new JTextField();
        JTextField postalCode = new JTextField();
        JTextField houseNumber = new JTextField();
        JTextField place = new JTextField();

        if (update && accounts.getSelectedItem() != null) {
            Account account = accountManager.getAccountById(((Account) accounts.getSelectedItem()).getId());

            fullName.setText(account.getName());
            streetName.setText(account.getStreetName());
            postalCode.setText(account.getPostalCode());
            houseNumber.setText(account.getHouseNumber());
            place.setText(account.getPlace());

        }

        final JComponent[] inputs = new JComponent[]{
                new JLabel("Full name"),
                fullName,
                new JLabel("Street name"),
                streetName,
                new JLabel("Postal code"),
                postalCode,
                new JLabel("House number"),
                houseNumber,
                new JLabel("Place"),
                place
        };

        int result = JOptionPane.showConfirmDialog(null, inputs, "Fill in the fields", JOptionPane.DEFAULT_OPTION);

        if (result == JOptionPane.OK_OPTION) {

            Account parseObj = new Account(0, fullName.getText(), streetName.getText(), postalCode.getText(), houseNumber.getText(), place.getText());

            if (update)
                accountManager.updateAccount(parseObj, (Account) accounts.getSelectedItem());
            else
                accountManager.addAccount(parseObj);

            updateCombobox();


            accounts.setSelectedItem(parseObj);

        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }

    public void ManageWatched() {
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

        int result = JOptionPane.showConfirmDialog(null, inputs, "Fill in the fields", JOptionPane.DEFAULT_OPTION);

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

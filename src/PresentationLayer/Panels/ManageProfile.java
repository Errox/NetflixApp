package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.ProfileManager;
import DomainModelLayer.Account;
import DomainModelLayer.Profile;
import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Controls.JCalendar;
import PresentationLayer.Controls.JMaxLengthTextBox;
import PresentationLayer.EventHandlers.*;

import javax.swing.*;
import java.awt.*;

public class ManageProfile extends JPanel {
    private JComboBox accounts, profiles;

    public ManageProfile() {
        setLayout(new BorderLayout());

        add(ManagePanelBase.InitializeButtonPane(
                new lForCreateProfile(this),
                new lForUpdateProfile(this),
                new lForDeleteProfile(this) ), BorderLayout.SOUTH);

        add(createContentPanel(), BorderLayout.NORTH);
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 0, 10));
        JLabel manageLabel = new JLabel(ControlNames.MANAGE_LABEL + ControlNames.TAB_PROFILES);
        panel.add(manageLabel);

        profiles = new JComboBox<>();

        accounts = new JComboBox<>();
        accounts.addActionListener(new lForProfileBox(accounts, profiles));
        panel.add(accounts);
        panel.add(profiles);

        updateCombobox();

        return panel;
    }

    public void updateCombobox() {
        accounts.setModel(new DefaultComboBoxModel(new AccountManager().getAllAccounts().toArray()));
        profiles.setModel(new DefaultComboBoxModel((new ProfileManager().getProfilesFromOwner((Account) accounts.getSelectedItem()).toArray())));
    }

    public Profile getSelectedObject() {
        return (Profile) profiles.getSelectedItem();
    }

    public void handleDelete(){
        int dialogResult = JOptionPane.showConfirmDialog(null, ControlNames.CONFIRM_REMOVE, ControlNames.CONFIRM_TITLE_WARNING, JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {

            Profile w = (Profile) getSelectedObject();
            System.out.println(w.getId());

            ProfileManager profileManager = new ProfileManager();

            profileManager.deleteProfile(w);
            updateCombobox();
        }
    }

    public void manageProfile(boolean update) {
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
}

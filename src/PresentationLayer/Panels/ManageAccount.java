package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.ProfileManager;
import DomainModelLayer.Account;
import DomainModelLayer.Profile;
import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Controls.JCalendar;
import PresentationLayer.Controls.JMaxLengthTextBox;
import PresentationLayer.EventHandlers.lForCreateAccount;
import PresentationLayer.EventHandlers.lForDeleteAccount;
import PresentationLayer.EventHandlers.lForUpdateAccount;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ManageAccount extends JPanel {

    private JComboBox accounts;

    public ManageAccount() {
        setLayout(new BorderLayout());

        add(ManagePanelBase.InitializeButtonPane(
                new lForCreateAccount(this),
                new lForUpdateAccount(this),
                new lForDeleteAccount(this) ), BorderLayout.SOUTH);

        add(createContentPanel(), BorderLayout.NORTH);
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 0, 10));
        JLabel manageLabel = new JLabel(ControlNames.MANAGE_LABEL + ControlNames.TAB_ACCCOUNT);
        panel.add(manageLabel);

        accounts = new JComboBox<>();
        panel.add(accounts);

        updateCombobox();

        return panel;
    }


    public void updateCombobox() {
        accounts.setModel(new DefaultComboBoxModel(new AccountManager().getAllAccounts().toArray()));
    }

    public Account getSelectedObject() {
        return (Account) accounts.getSelectedItem();
    }

    public void handleDelete(){
        int dialogResult = JOptionPane.showConfirmDialog(null, ControlNames.CONFIRM_REMOVE, ControlNames.CONFIRM_TITLE_WARNING, JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            Account toBeDeleted = (Account) getSelectedObject();
            System.out.println(toBeDeleted.getId());

            AccountManager accountManager = new AccountManager();
            accountManager.deleteAccounts(toBeDeleted);
            updateCombobox();
        }
    }

    public void manageAccount(boolean update) {
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
            Profile f = pfm.getProfileById(((Account) getSelectedObject()).getId());
            birthday.setText(f.getBirthDate().toString());
        }

        ArrayList<JComponent> jComponents = new ArrayList<JComponent>();

        jComponents.add(new JLabel(ControlNames.FULL_NAME));
        jComponents.add(fullName);
        jComponents.add(new JLabel(ControlNames.STREET_NAME));
        jComponents.add(streetName);
        jComponents.add(new JLabel(ControlNames.POSTAL_CODE));
        jComponents.add(postalCode);
        jComponents.add(new JLabel(ControlNames.HOUSE_NUMBER));
        jComponents.add(houseNumber);
        jComponents.add(new JLabel(ControlNames.PLACE));
        jComponents.add(place);
        jComponents.add(new JLabel(ControlNames.BIRTHDAY));
        jComponents.add(birthday);

        if (update) {

            int size = jComponents.size();
            //Remove the Birthday elements
            for (int i = 1; i < 3; i++) {
                jComponents.remove(size - i);
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
}

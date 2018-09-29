package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.ProfileManager;

import javax.swing.*;

public class AccountSeriesPanel extends JPanel {

    public AccountSeriesPanel() {

        AccountManager accountManager = new AccountManager();
        add(new JComboBox<>(accountManager.getAllAccounts().toArray()));

        ProfileManager profileManager = new ProfileManager();
        add(new JComboBox<>(profileManager.getAllProfiles().toArray()));
    }
}

package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;

import javax.swing.*;

public class AccountMoviePanel extends JPanel {

//Op deze panel kan er een account worden gekozen er word dan weergegeven welke films er door dit account zijn bekeken


    public AccountMoviePanel() {
        AccountManager accountManager = new AccountManager();

        add(new JComboBox<>(new AccountManager().getAllAccounts().toArray()));


        JList list = new JList();
        add(list);

    }
}

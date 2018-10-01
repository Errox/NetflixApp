package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import DomainModelLayer.Account;

import javax.swing.*;
import java.util.List;

public class AccountMoviePanel extends JPanel {

//Op deze panel kan er een account worden gekozen er word dan weergegeven welke films er door dit account zijn bekeken

    //AccountMoviePanel < Ryan
    public AccountMoviePanel() {
        AccountManager accountManager = new AccountManager();

        List<Account> accountList = accountManager.getAllAccounts();
        add(new JComboBox<>(accountList.toArray()));


        JList list = new JList();
        add(list);

    }
}

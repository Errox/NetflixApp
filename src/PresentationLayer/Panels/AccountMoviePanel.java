package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import DomainModelLayer.Account;

import javax.swing.*;
import java.util.List;

public class AccountMoviePanel extends JPanel {

    //6. Voor een door de gebruiker geselecteerde film, hoeveel kijkers hebben deze in z’n geheel bekeken

    public AccountMoviePanel() {
        AccountManager accountManager = new AccountManager();

        List<Account> accountList = accountManager.getAllAccounts();
        add(new JComboBox<>(accountList.toArray()));


        JList list = new JList();
        add(list);
    }
}

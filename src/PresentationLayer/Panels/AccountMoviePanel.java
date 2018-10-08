package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import DomainModelLayer.Account;

import javax.swing.*;
import java.util.List;

public class AccountMoviePanel extends JPanel {
    //3. Welke films zijn er door een door de gebruiker geselecteerd account bekeken?



    public AccountMoviePanel() {
        AccountManager accountManager = new AccountManager();

        List<Account> accountList = accountManager.getAllAccounts();
        add(new JComboBox<>(accountList.toArray()));


        JList list = new JList();
        add(list);
    }
}

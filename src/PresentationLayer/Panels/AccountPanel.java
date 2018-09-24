package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import DataStorageLayer.SqlServer.SqlServerAccountDAO;
import DomainModelLayer.Account;

import javax.swing.*;
import java.util.List;

public class AccountPanel extends JPanel {

    private List<Account> accountList;
    private AccountManager accountManager = new AccountManager();

    public AccountPanel(){



    }
}

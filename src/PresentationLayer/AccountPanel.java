package PresentationLayer;

import ApplicationLayer.AccountManager;
import DataStorageLayer.SqlServer.SqlServerAccountDAO;

import javax.swing.*;

public class AccountPanel extends JPanel {

    public AccountPanel(){
        AccountManager accountManager = new AccountManager();
        accountManager.getAllAccounts();
    }
}

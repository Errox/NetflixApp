import ApplicationLayer.AccountManager;
import DataStorageLayer.Helpers.MSSQLHelper;
import DataStorageLayer.SqlServer.SqlServerAccountDAO;
import DomainModelLayer.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Entry point of application.

        //Anon type of Accountmanager, Program to an interface.
        //Inject dependency of concrete class.
        AccountManager accountManager = new AccountManager(new SqlServerAccountDAO());

        //Get by id from data provider
        accountManager.getAccountById(1);

        //Get all Accounts from data provider
        accountManager.getAllAccounts();

        //Insert account to data provider
        accountManager.addAccount(new Account("Yo", "test", "test", "test", "test" ));

        //Delete account from data provider
        accountManager.deleteAccount(new Account(1, "Yo", "test", "test", "test", "test" ));

        //Update account from data provider
        accountManager.updateAccount(
                new Account(1, "Yo", "test", "test", "test", "test" ),
                new Account("Yo", "test", "test", "test", "test" ));
    }
}

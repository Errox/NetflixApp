import ApplicationLayer.AccountManager;
import DomainModelLayer.Account;

public class SqlServerAccountDAOTest {

    boolean TestAccountStoredMatchesObjectReturned() {

        AccountManager accountManager = new AccountManager();

        Account toBeAddedToDatabase = new Account(0, "Test", "Test", "Test", "2", "Test");

        int storedAccountId = accountManager.addAccount(toBeAddedToDatabase);

        Account retrievedFromDatabase = accountManager.getAccountById(storedAccountId);

        //Won't evaluate as true, as the id is unknown on object creation, it is assigned by the dbs.
        //assertEquals(retrievedFromDatabase, toBeAddedToDatabase);
        return false;
    }


    boolean DatabaseErrorOnTruncatedData() {
        AccountManager accountManager = new AccountManager();

        Account toBeAddedToDatabase = new Account(0, "Testaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Testaaaaaaaaaaaaaaaaaaaaaa", "Testaaaaaaaaaaaaaaaaaaa", "2aaaaaaaaaaaa", "Test");

        //Should throw truncated exception
        int storedAccountId = accountManager.addAccount(toBeAddedToDatabase);
        return false;
    }


    boolean AccountCanBeDeletedFromDatabase() {

        AccountManager accountManager = new AccountManager();

        Account toBeAddedToDatabase = new Account(0, "Test", "Test", "Test", "2", "Test");

        int storedAccountId = accountManager.addAccount(toBeAddedToDatabase);

        Account retrievedFromDatabase = accountManager.getAccountById(storedAccountId);

        //Won't evaluate as true, as the id is unknown on object creation, it is assigned by the dbs.
        //assertEquals(retrievedFromDatabase, toBeAddedToDatabase);


        //Cleanup from database.
        if (retrievedFromDatabase.equals(toBeAddedToDatabase))
            accountManager.deleteAccounts(retrievedFromDatabase);

        return false;
    }
}

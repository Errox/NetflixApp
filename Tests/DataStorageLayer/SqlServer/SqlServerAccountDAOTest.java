package DataStorageLayer.SqlServer;

import ApplicationLayer.AccountManager;
import DomainModelLayer.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SqlServerAccountDAOTest {

    @Test
    void TestAccountStoredMatchesObjectReturnedFromDataStorageLayer() {

        AccountManager accountManager = new AccountManager();

        Account toBeAddedToDatabase = new Account(0, "Test", "Test", "Test", "2", "Test");

        int storedAccountId = accountManager.addAccount(toBeAddedToDatabase);

        int retrievedFromDatabase = accountManager.getAccountById(storedAccountId).getId();

        Assertions.assertEquals(storedAccountId, retrievedFromDatabase);
    }

    @Test
    void TestAccountCanBeDeletedFromDatabaseAfterCreating() {

        AccountManager accountManager = new AccountManager();

        Account toBeAddedToDatabase = new Account(0, "Test", "Test", "Test", "2", "Test");

        int storedAccountId = accountManager.addAccount(toBeAddedToDatabase);

        Account retrievedFromDatabase = accountManager.getAccountById(storedAccountId);


        boolean cleaned = false;
        //Cleanup from database.
            accountManager.deleteAccounts(retrievedFromDatabase);
            Account c = accountManager.getAccountById(retrievedFromDatabase.getId());
            if(c == null)
                cleaned = true;

        Assertions.assertTrue(cleaned);
    }

}
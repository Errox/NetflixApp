package DataStorageLayer.SqlServer;

import ApplicationLayer.AccountManager;
import DomainModelLayer.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SqlServerAccountDAOTest {
    //Arrange – setup the testing objects and prepare the prerequisites for your test.
    //Act – perform the actual work of the test.
    //Assert – verify the result.

    @Test
    void TestAccountStoredMatchesObjectReturnedFromDataStorageLayer() {
        //Arrange
        AccountManager accountManager = new AccountManager();
        Account toBeAddedToDatabase = new Account(0, "Test", "Test", "Test", "2", "Test");

        //Act

        //Store the Id temporary
        int storedAccountId = accountManager.addAccount(toBeAddedToDatabase);

        //Get the account by its stored Id
        int retrievedFromDatabase = accountManager.getAccountById(storedAccountId).getId();

        //Assert

        //Assert if retrieved object matches object created
        Assertions.assertEquals(storedAccountId, retrievedFromDatabase);

        //After cleanup.
        cleanUpSuccessful(accountManager, new Account(retrievedFromDatabase, "", "", "", "", ""));
    }


    @Test
    void TestAccountCanBeDeletedFromDatabaseAfterCreating() {
        AccountManager accountManager = new AccountManager();
        Account toBeAddedToDatabase = new Account(0, "Test", "Test", "Test", "2", "Test");

        int storedAccountId = accountManager.addAccount(toBeAddedToDatabase);

        Account retrievedFromDatabase = accountManager.getAccountById(storedAccountId);

        Assertions.assertTrue(cleanUpSuccessful(accountManager, retrievedFromDatabase));
    }


    public boolean cleanUpSuccessful(AccountManager accountManager, Account retrievedFromDatabase){
        boolean cleaned = false;
        //Cleanup from database.
        accountManager.deleteAccounts(retrievedFromDatabase);
        Account c = accountManager.getAccountById(retrievedFromDatabase.getId());
        if(c == null)
            cleaned = true;

        return cleaned;
    }

}
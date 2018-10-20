package DataStorageLayer.SqlServer;

import ApplicationLayer.AccountManager;
import ApplicationLayer.WatchedManager;
import DomainModelLayer.Account;
import DomainModelLayer.Watched;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void TestUpdateAccountMatchesObjectReturnedFromDatabase(){
        //Arrange
        AccountManager accountManager = new AccountManager();
        Account toBeAddedToDatabase = new Account(0, "Test", "Test", "Test", "2", "Test");

        int storedAccountId = accountManager.addAccount(toBeAddedToDatabase);

        //Get the account by its stored Id
        Account retrievedFromDatabase = accountManager.getAccountById(storedAccountId);

        //Assert
        Assertions.assertEquals(retrievedFromDatabase.getId(), storedAccountId);

        //After cleanup.
        cleanUpSuccessful(accountManager, retrievedFromDatabase);
    }


    @Test
    void TestAccountThatHasTruncatedDataWillNotThrowErrorAccountManager(){
        //Arrange
        Account toBeAddedToDatabase = new Account(0, "TestTestTestTestTestTestTestTest", "TestTestTestTestTestTestTestTestTestTestTest", "TestTestTestTestTestTestTestTest", "2", "Test");

        // RF spec: Asserts that all supplied executables do not throw exceptions.

        SqlServerAccountDAO sqlAccountDAO = new SqlServerAccountDAO();

        Assertions.assertAll(() -> sqlAccountDAO.addAccount(toBeAddedToDatabase));
    }

    @Test
    void TestAccountCanBeDeletedFromDatabaseAfterCreating() {
        //Arrange

        AccountManager accountManager = new AccountManager();
        Account toBeAddedToDatabase = new Account(0, "Test", "Test", "Test", "2", "Test");

        //Act
        int storedAccountId = accountManager.addAccount(toBeAddedToDatabase);

        Account retrievedFromDatabase = accountManager.getAccountById(storedAccountId);

        //Assert
        Assertions.assertTrue(cleanUpSuccessful(accountManager, retrievedFromDatabase));
    }

    @Test
    void TestAccountCanBeDeletedWithANonExistentAccount(){
        //Arrange
        AccountManager accountManager = new AccountManager();


        // RF spec: Asserts that all supplied executables do not throw exceptions.
        Assertions.assertAll(() -> accountManager.deleteAccounts(new Account(999999, "", "","", "", "")));
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

    public static class SqlServerWatchedDAOTest {


    }
}
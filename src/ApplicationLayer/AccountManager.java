package ApplicationLayer;

import DataStorageLayer.DAO.AccountDAO;
import DataStorageLayer.Factories.DAOFactory;
import DomainModelLayer.Account;

import java.util.List;

public class AccountManager implements AccountDAO {

    private AccountDAO accountDAO;

    /**
     * Creates an instance of the Account Manager,
     * that uses the Dao specified in the constructor to
     * -Create
     * -Read
     * -Update
     * -Delete
     */

    public AccountManager() {
        this.accountDAO = DAOFactory.getAccountDAOInstance();
    }

    /**
     * -Returns all Accounts by the data storage layer provided.
     */
    public List<Account> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }


    /**
     * -Returns Account associated by the provided id, from the storage layer provided.
     */
    public Account getAccountById(int id) {
        return accountDAO.getAccountById(id);
    }

    /**
     * -Adds an account to the data storage layer provided
     *
     * @param newAccount represents the new 'Account' that will be added to the Data storage
     * returns the Id from the newly inserted Record;
     */
    public int addAccount(Account newAccount) {
        return accountDAO.addAccount(newAccount);
    }

    /**
     * -Updates an account by specifying the new and old account.
     * Old account is used to find the 'old '- account
     * so we can replace those values within the Data storage
     */
    public void updateAccount(Account newAccount, Account oldAccount) {
        accountDAO.updateAccount(oldAccount, newAccount);
    }

    /**
     * -Deletes an account by specifying the to be deleted account(s).
     * <p>
     * "as of type List, it is easier to implement both delete / delete (multiple)
     * then representing both methods as maintainable"
     */
    @Override
    public void deleteAccounts(Account deleteAccount) {
        accountDAO.deleteAccounts(deleteAccount);
    }
}

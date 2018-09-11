package ApplicationLayer;

import DataStorageLayer.DAO.AccountDAO;
import DomainModelLayer.Account;

import java.util.List;

public class AccountManager {

    private AccountDAO accountDAO;

    /**
     * Creates an instance of the Account Manager,
     * that uses the Dao specified in the constructor to
     * -Create
     * -Read
     * -Update
     * -Delete
     * @param  dao the DAO that meets the contract.
     */

    public AccountManager(AccountDAO dao){
        this.accountDAO = dao;
    }

     /**
     * -Returns all Accounts by the data storage layer provided.
      * */
    public List<Account> getAllAccounts(){
        return accountDAO.getAllAccounts();
    }


    /**
     * -Returns Account associated by the provided id, from the storage layer provided.
     * */
    public Account getAccountById(int id){
        return accountDAO.getAccountById(id);
    }

    /**
    * -Adds an account to the data storage layer provided
     * @param newAccount represents the new 'Account' that will be added to the Data storage
    */
    public void addAccount(Account newAccount){
        accountDAO.addAccount(newAccount);
    }

     /**
     * -Updates an account by specifiying the new and old account.
      * Old account is used to find the 'old '- account
      * so we can replace those values within the Data storage
     */
    public void updateAccount(Account newAccount, Account oldAccount){
        accountDAO.updateAccount(oldAccount, newAccount);
    }

    /**
     * -Deletes an account by specifying the to be deleted account(s).
     *
     * "as of type List, it is easier to implement both delete / delete (multiple)
     * then representing both methods as maintainable"
     */
    public void deleteAccount(Account deleteAccount){
        accountDAO.deleteAccounts(deleteAccount);
    }

}

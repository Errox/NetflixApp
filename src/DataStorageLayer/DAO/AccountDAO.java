package DataStorageLayer.DAO;

import DomainModelLayer.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> getAllAccounts();
    Account getById(int id);

    void addAccount(Account newAccount);
    void updateAccount(Account oldAccount, Account newAccount);
    void deleteAccounts(Account deleteAccount);
}

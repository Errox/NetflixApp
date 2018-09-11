package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.AccountDAO;
import DomainModelLayer.Account;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlServerAccountDAO implements AccountDAO {

    @Override
    public List<Account> getAllAccounts() {

        List<Account> accounts = new ArrayList<>();
        List<Map<String, Object>> queryResult =  null; //SqlHelperResultSet.getInstance().execRawQuery("SELECT * FROM Account");

        for (int i = 0; i < queryResult.size(); i++){
            //Store separately to Map to get values.
            Map<String, Object> objectMap = queryResult.get(i);

            //Case Sensitively retrieving by column name.
            //Should be by reflection.
            Account account = new Account(
                    Integer.parseInt(objectMap.get("subscriptionNumber").toString()),
                    objectMap.get("name").toString(),
                    objectMap.get("streetName").toString(),
                    objectMap.get("postalCode").toString(),
                    objectMap.get("houseNumber").toString(),
                    objectMap.get("place").toString()
                    );

            accounts.add(account);
        }
         return accounts;
    }

    @Override
    public Account getAccountById(int id) {
        return null;
    }

    //Re-write query.
    @Override
    public void addAccount(Account newAccount) {

//        SqlHelperResultSet.getInstance().execCreatebyVal("Account",
//                 newAccount.getName(),
//                 newAccount.getStreetName(),
//                 newAccount.getPostalCode(),
//                 newAccount.getHouseNumber(),
//                 newAccount.getPlace());

    }

    @Override
    public void updateAccount(Account oldAccount, Account newAccount) {

//        Map<String, Object> changed = new HashMap<>();
//        changed.put("name", newAccount.getName());
//        changed.put("streetName", newAccount.getStreetName());
//        changed.put("postalCode", newAccount.getPostalCode());
//        changed.put("houseNumber", newAccount.getHouseNumber());
//        changed.put("place", newAccount.getPlace());
//
//        Map<String, Object> old = new HashMap<>();
//        old.put("name", oldAccount.getName());
//        old.put("streetName", oldAccount.getStreetName());
//        old.put("postalCode", oldAccount.getPostalCode());
//        old.put("houseNumber", oldAccount.getHouseNumber());
//        old.put("place", oldAccount.getPlace());
//
//        SqlHelperResultSet.getInstance().execUpdateByVal("Account", changed, old);
  }

    @Override
    public void deleteAccounts( Account deleteAccount) {
//        Map<String, Object> toDelete = new HashMap<>();
//        toDelete.put("subscriptionNumber", deleteAccount.getSubscriptionNumber());
//
//        SqlHelperResultSet.getInstance().execDeleteByVal("Account", toDelete);
    }
}
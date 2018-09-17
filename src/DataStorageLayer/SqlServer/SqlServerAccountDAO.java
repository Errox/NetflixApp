package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.AccountDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlServerAccountDAO implements AccountDAO {

    private MSSQLHelper MSSQLDatabase;

    public SqlServerAccountDAO() {
        this.MSSQLDatabase = new MSSQLHelper();
    }

    @Override
    public List<Account> getAllAccounts() {

       Connection connection =  MSSQLDatabase.getConnection();
       List<Account> accounts = new ArrayList<Account>();
       Statement statement = null;
       ResultSet resultSet = null;

        try{
           String sqlQuery = "";
           statement = connection.createStatement();
           resultSet = statement.executeQuery(sqlQuery);

           while(resultSet.next()){

               int subscriptionId = resultSet.getInt("subscriptionId");
               String name = resultSet.getString("name");
               String streetName = resultSet.getString("streetName");
               String postalCode = resultSet.getString("postalCode");
               String houseNumber = resultSet.getString("houseNumber");
               String place = resultSet.getString("place");

               //Add our account from resultSet to list.
               accounts.add(new Account(subscriptionId, name, streetName, postalCode, houseNumber, place));
           }

       }catch (Exception e){
            //Print on error.
           e.printStackTrace();
       }finally {
            //Clean our resources.
           MSSQLDatabase.closeResources(resultSet, statement, connection);
       }

        return accounts;
    }

    @Override
    public Account getAccountById(int id) {
        Connection connection =  MSSQLDatabase.getConnection();
        Account account = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            String sqlQuery = "";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){

                int subscriptionId = resultSet.getInt("subscriptionId");
                String name = resultSet.getString("name");
                String streetName = resultSet.getString("streetName");
                String postalCode = resultSet.getString("postalCode");
                String houseNumber = resultSet.getString("houseNumber");
                String place = resultSet.getString("place");

                //Add our account from db to list.
                account = new Account(subscriptionId, name, streetName, postalCode, houseNumber, place);
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return account;
    }

    @Override
    public void addAccount(Account newAccount) {
        Connection connection =  MSSQLDatabase.getConnection();
        PreparedStatement preparedStatement = null;

        //Finalize query
        try{
            String sqlQuery = "INSERT INTO Accounts VALUES ( ?, ?, ?, ?, ? )";
            preparedStatement = connection.prepareStatement(sqlQuery);

            //Index 1 or 0?
            preparedStatement.setString(1, newAccount.getName());
            preparedStatement.setString(2, newAccount.getStreetName());
            preparedStatement.setString(3, newAccount.getPostalCode());
            preparedStatement.setString(4, newAccount.getHouseNumber());
            preparedStatement.setString(5, newAccount.getPlace());

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeStatementResources(preparedStatement);
            MSSQLDatabase.closeConnectionResource(connection);
        }
    }

    @Override
    public void updateAccount(Account oldAccount, Account newAccount) {
        Connection connection =  MSSQLDatabase.getConnection();
        PreparedStatement preparedStatement = null;

        //Finalize query
        try{
            String sqlQuery = "UPDATE Accounts SET name = ?, streetName = ?, postalCode = ?, houseNumber = ?, place = ? WHERE subscriptionId = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);

            //Index 1 or 0?
            preparedStatement.setString(1, oldAccount.getName());
            preparedStatement.setString(2, oldAccount.getStreetName());
            preparedStatement.setString(3, oldAccount.getPostalCode());
            preparedStatement.setString(4, oldAccount.getHouseNumber());
            preparedStatement.setString(5, oldAccount.getPlace());
            preparedStatement.setInt(6, oldAccount.getId());

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeStatementResources(preparedStatement);
            MSSQLDatabase.closeConnectionResource(connection);

        }
    }

    @Override
    public void deleteAccounts( Account deleteAccount) {
        Connection connection =  MSSQLDatabase.getConnection();
        Statement statement = null;

        //Finalize with parameter query
        try{
            String sqlQuery = "DELETE FROM Accounts WHERE subscriptionId " + deleteAccount.getId();
            statement = connection.createStatement();
            statement.execute(sqlQuery);
        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeStatementResources(statement);
            MSSQLDatabase.closeConnectionResource(connection);
        }
    }
}
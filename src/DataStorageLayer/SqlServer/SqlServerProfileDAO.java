package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.ProfileDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlServerProfileDAO implements ProfileDAO {

    //[SubscriptionNumber] [int] NOT NULL,
    //[Name] [nvarchar](50) NOT NULL,
    //[Birthdate] [date] NULL,

    private MSSQLHelper MSSQLDatabase;

    public SqlServerProfileDAO() {
        this.MSSQLDatabase = new MSSQLHelper();
    }

    @Override
    public List<Profile> getAllProfiles() {
        Connection connection =  MSSQLDatabase.getConnection();
        List<Profile> profiles = new ArrayList<Profile>();
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
                profiles.add(null);//new Profile(subscriptionId, name, streetName, postalCode, houseNumber, place));
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return profiles;
    }

    @Override
    public Profile getProfileById(int id) {
        Connection connection =  MSSQLDatabase.getConnection();
        Profile profile = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            String sqlQuery = "";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){

//                int subscriptionId = resultSet.getInt("subscriptionId");
//                String name = resultSet.getString("name");
//                String streetName = resultSet.getString("streetName");
//                String postalCode = resultSet.getString("postalCode");
//                String houseNumber = resultSet.getString("houseNumber");
//                String place = resultSet.getString("place");

                //Add our account from db to list.
                profile = null;//new Account(subscriptionId, name, streetName, postalCode, houseNumber, place);
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return profile;
    }

    @Override
    public void addProfile(Profile newProfiles) {
        Connection connection =  MSSQLDatabase.getConnection();
        PreparedStatement preparedStatement = null;

        //Finalize query
        try{
            String sqlQuery = "INSERT INTO Profiles VALUES ( ?, ?, ?, ?, ? )";
            preparedStatement = connection.prepareStatement(sqlQuery);

            //Index 1 or 0?
//            preparedStatement.setString(1, newAccount.getName());
//            preparedStatement.setString(2, newAccount.getStreetName());
//            preparedStatement.setString(3, newAccount.getPostalCode());
//            preparedStatement.setString(4, newAccount.getHouseNumber());
//            preparedStatement.setString(5, newAccount.getPlace());

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
    public void updateProfile(Profile oldProfile, Profile newProfile) {
        Connection connection =  MSSQLDatabase.getConnection();
        PreparedStatement preparedStatement = null;

        //Finalize query
        try{
            String sqlQuery = "UPDATE Accounts SET name = ?, streetName = ?, postalCode = ?, houseNumber = ?, place = ? WHERE subscriptionId = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);

            //Index 1 or 0?
//            preparedStatement.setString(1, oldAccount.getName());
//            preparedStatement.setString(2, oldAccount.getStreetName());
//            preparedStatement.setString(3, oldAccount.getPostalCode());
//            preparedStatement.setString(4, oldAccount.getHouseNumber());
//            preparedStatement.setString(5, oldAccount.getPlace());
//            preparedStatement.setInt(6, oldAccount.getId());

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
    public void deleteProfile(Profile deleteProfile) {
        Connection connection =  MSSQLDatabase.getConnection();
        Statement statement = null;

        //Finalize with parameter query
        try{
            String sqlQuery = "DELETE FROM Accounts WHERE subscriptionId " + deleteProfile.getId();
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

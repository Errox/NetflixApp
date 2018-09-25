package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.ProfileDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
        Connection connection = MSSQLDatabase.getConnection();
        List<Profile> profiles = new ArrayList<Profile>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            String sqlQuery = "Select * from Profiles";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {

                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                Date BirthDate = resultSet.getDate("BirthDate");
                int AccountId = resultSet.getInt("AccountId");
                //Add our account from resultSet to list.
                profiles.add(new Profile(id, name, BirthDate, AccountId));
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return profiles;
    }

    @Override
    public Profile getProfileById(int id) {
        Connection connection = MSSQLDatabase.getConnection();
        Profile profile = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM Profiles WHERE Id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int ProfileId = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                Date BirthDate = resultSet.getDate("BirthDate");
                int Acoountid = resultSet.getInt("AccountId");
                profile = new Profile(ProfileId, name, BirthDate, Acoountid);
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return profile;
    }

    @Override
    public void addProfile(Profile newProfiles) {
        Connection connection = MSSQLDatabase.getConnection();
        PreparedStatement preparedStatement = null;

        //Finalize query
        try {
            String sqlQuery = "INSERT INTO Profiles (Name, BirthDate, AccountId) VALUES ( ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlQuery);

            //Index 1 or 0?
            preparedStatement.setString(1, newProfiles.getName());
            preparedStatement.setDate(2, new java.sql.Date(newProfiles.getBirthDate().getTime()));
            preparedStatement.setInt(3, newProfiles.getId());
            preparedStatement.execute();

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeStatementResources(preparedStatement);
            MSSQLDatabase.closeConnectionResource(connection);
        }
    }


    @Override
    public void updateProfile(Profile oldProfile, Profile newProfile) {
        Connection connection = MSSQLDatabase.getConnection();
        PreparedStatement preparedStatement = null;

        //Finalize query
        try {
            String sqlQuery = "UPDATE Profiles SET Name = ?, BirthDate = ?, AccountId = ? WHERE Id = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, newProfile.getName());
            preparedStatement.setDate(2, new java.sql.Date(newProfile.getBirthDate().getTime()));
            preparedStatement.setInt(3, newProfile.getId());
            preparedStatement.setInt(4, oldProfile.getId());
            preparedStatement.execute();

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeStatementResources(preparedStatement);
            MSSQLDatabase.closeConnectionResource(connection);

        }
    }

    @Override
    public void deleteProfile(Profile deleteProfile) {
        Connection connection = MSSQLDatabase.getConnection();
        Statement statement = null;

        //Finalize with parameter query
        try {
            String sqlQuery = "DELETE FROM Profiles WHERE Id =" + deleteProfile.getId();
            statement = connection.createStatement();
            statement.execute(sqlQuery);
        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeStatementResources(statement);
            MSSQLDatabase.closeConnectionResource(connection);
        }
    }
}

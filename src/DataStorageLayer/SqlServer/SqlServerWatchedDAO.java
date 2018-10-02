package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.WatchedDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Account;
import DomainModelLayer.Profile;
import DomainModelLayer.Serie;
import DomainModelLayer.Watched;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class SqlServerWatchedDAO implements WatchedDAO {

    private MSSQLHelper MSSQLDatabase;

    public SqlServerWatchedDAO() {
        this.MSSQLDatabase = new MSSQLHelper();
    }

    @Override
    public List<Watched> getAllWatched() {
        Connection connection = MSSQLDatabase.getConnection();
        List<Watched> watched = new ArrayList<Watched>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            String sqlQuery = "SELECT * FROM Watched";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {

                int id = resultSet.getInt("Id");
                int Percentage = resultSet.getInt("Percentage");
                int ProfileId = resultSet.getInt("ProfileId");
                int ProgramId = resultSet.getInt("ProgramId");
                watched.add(new Watched(id, Percentage, ProfileId, ProgramId));
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Release our resources.
            MSSQLDatabase.closeResources(resultSet, statement);
        }

        return watched;
    }

    @Override
    public Watched getWatchedById(int id) {
        Connection connection = MSSQLDatabase.getConnection();
        Watched watched = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM Watched WHERE Id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();


            while (resultSet.next()) {

                int watchedId = resultSet.getInt("Id");
                int Percentage = resultSet.getInt("Percentage");
                int ProfileId = resultSet.getInt("ProfileId");
                int ProgramId = resultSet.getInt("ProgramId");

                watched = new Watched(watchedId, Percentage, ProfileId, ProgramId);
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Release our resources.
            MSSQLDatabase.closeResources(resultSet, statement);
        }

        return watched;
    }

    @Override
    public List<Watched> getAllWatchedForProfile(Profile profile) {
        Connection connection = MSSQLDatabase.getConnection();

        List<Watched> watched = new ArrayList<Watched>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //TO PARAMS.
            String sqlQuery = "SELECT * FROM Watched WHERE ProfileId= " + profile.getId();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {

                int id = resultSet.getInt("Id");
                int Percentage = resultSet.getInt("Percentage");
                int ProfileId = resultSet.getInt("ProfileId");
                int ProgramId = resultSet.getInt("ProgramId");
                watched.add(new Watched(id, Percentage, ProfileId, ProgramId));
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Release our resources.
            MSSQLDatabase.closeResources(resultSet, statement);
        }

        return watched;
    }

    @Override
    public void addWatched(Watched newWatched) {
        Connection connection = MSSQLDatabase.getConnection();
        PreparedStatement preparedStatement = null;

        //Finalize query
        try {
            String sqlQuery = "INSERT INTO Watched VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlQuery);

            //Index 1 or 0?
            preparedStatement.setInt(1, newWatched.getPercentage());
            preparedStatement.setInt(2, newWatched.getProfileId());
            preparedStatement.setInt(3, newWatched.getProgramId());
            preparedStatement.execute();
        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Release our resources.
            MSSQLDatabase.closeStatementResources(preparedStatement);
        }
    }

    @Override
    public void updateWatched(Watched oldWatched, Watched newWatched) {
        Connection connection = MSSQLDatabase.getConnection();
        PreparedStatement preparedStatement = null;

        //Finalize query
        try {
            String sqlQuery = "UPDATE Watched SET  Percentage = ?, ProfileId = ?, ProgramId = ? WHERE Id = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);

            //Index 1 or 0?

            preparedStatement.setInt(1, newWatched.getPercentage());
            preparedStatement.setInt(2, newWatched.getProfileId());
            preparedStatement.setInt(3, newWatched.getProgramId());
            preparedStatement.setInt(4, oldWatched.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Release our resources.
            MSSQLDatabase.closeStatementResources(preparedStatement);
        }
    }

    @Override
    public void deleteWatched(Watched deleteWatch) {
        Connection connection = MSSQLDatabase.getConnection();
        Statement statement = null;

        //Finalize with parameter query
        try {
            String sqlQuery = "DELETE FROM Watched WHERE subscriptionId " + deleteWatch.getId();
            statement = connection.createStatement();
            statement.execute(sqlQuery);
        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Release our resources.
            MSSQLDatabase.closeStatementResources(statement);
        }
    }

    @Override
    public List<Integer> getWatchedTimeForEpisodesBySerie(Account account, Serie serie) {
        Connection connection = MSSQLDatabase.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Integer> watchedList = new ArrayList<>();


        try {

            statement = connection.prepareStatement(
                    "SELECT Watched.Percentage FROM Programs" +
                    " JOIN Episodes ON Episodes.ProgramId = Programs.Id" +
                    " JOIN Profiles ON AccountId = Profiles.AccountId" +
                    " JOIN Watched ON Watched.ProgramId = Programs.Id" +
                    " WHERE Profiles.AccountId = ? AND SerieId = ?");

            statement.setInt(1, account.getId());
            statement.setInt(2, serie.getId());

            resultSet = statement.executeQuery();



            while (resultSet.next()) {
                watchedList.add(resultSet.getInt("Percentage"));
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return watchedList;
    }
}

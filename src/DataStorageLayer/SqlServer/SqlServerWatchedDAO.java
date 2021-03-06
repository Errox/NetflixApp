package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.WatchedDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                watched.add(new Watched(id, Percentage, ProgramId, ProfileId));
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
    public int addWatched(Watched newWatched) {
        Connection connection = MSSQLDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        int watchedId = 0;
        //Finalize query
        try {
            String sqlQuery = "INSERT INTO Watched (Percentage, ProfileId, ProgramId) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);

            //Index 1 or 0?
            preparedStatement.setInt(1, newWatched.getPercentage());
            preparedStatement.setInt(2, newWatched.getProfileId());
            preparedStatement.setInt(3, newWatched.getProgramId());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                watchedId = rs.getInt(1);
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Release our resources.
            MSSQLDatabase.closeStatementResources(preparedStatement);
        }
        return watchedId;
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
            String sqlQuery = "DELETE FROM Watched WHERE Id = " + deleteWatch.getId();
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
    public List<Integer> getWatchedTimeForEpisodesBySerieOfAccount(Account account, Serie serie) {
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

    @Override
    public Map<Episode, Integer> getWatchedTimeForEpisodes(List<Episode> episodes) {
        Connection connection = MSSQLDatabase.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Map<Episode, Integer> seriesPercentage = new HashMap<>();

        try {
            for (Episode episode : episodes) {
                statement = connection.prepareStatement(
                        "SELECT avg(Watched.Percentage) as percentage FROM Episodes INNER JOIN Programs ON Episodes.ProgramId = Programs.Id INNER JOIN Watched ON Programs.Id = Watched.ProgramId AND Programs.Id = Watched.ProgramId WHERE Episodes.ProgramId = ?");

                statement.setInt(1, episode.getProgramId());

                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    seriesPercentage.put(episode, resultSet.getInt("percentage"));
                } else {
                    seriesPercentage.put(episode, 0);
                }

            }
        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return seriesPercentage;
    }

}

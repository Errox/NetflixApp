package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.WatchedDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Watched;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlServerWatchedDAO implements WatchedDAO {

    //[SubscriptionNumber] [int] NOT NULL,
    //[Name] [nvarchar](50) NOT NULL,
    //[Seen] [int] NOT NULL,
    //[Watched] [int] NULL,
    private MSSQLHelper MSSQLDatabase;

    public SqlServerWatchedDAO() {
        this.MSSQLDatabase = new MSSQLHelper();
    }

    @Override
    public List<Watched> getAllWatched() {
        Connection connection =  MSSQLDatabase.getConnection();
        List<Watched> watched = new ArrayList<Watched>();
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            String sqlQuery = "";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){

                int subscriptionId = resultSet.getInt("subscriptionNumber");
                String name = resultSet.getString("name");
                int seen = resultSet.getInt("seen");
                int watchedper = resultSet.getInt("watched");
                watched.add(new Watched(subscriptionId, name, seen, watchedper));
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement);
        }

        return watched;
    }

    @Override
    public Watched getWatchedById(int id) {
        Connection connection =  MSSQLDatabase.getConnection();
        Watched watched = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            String sqlQuery = "";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){

                int subscriptionId = resultSet.getInt("subscriptionNumber");
                String name = resultSet.getString("name");
                int seen = resultSet.getInt("seen");
                int watchedper = resultSet.getInt("watched");
                watched = new Watched(subscriptionId, name, seen, watchedper);
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement);
        }

        return watched;
    }

    @Override
    public void addWatched(Watched newWatched) {
        Connection connection =  MSSQLDatabase.getConnection();
        PreparedStatement preparedStatement = null;

        //Finalize query
        try{
            String sqlQuery = "INSERT INTO Watched VALUES ( ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlQuery);

            //Index 1 or 0?
            preparedStatement.setInt(1, newWatched.getId());
            preparedStatement.setString(2, newWatched.getName());
            preparedStatement.setInt(3, newWatched.getSeen());
            preparedStatement.setInt(4, newWatched.getPercentage());

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeStatementResources(preparedStatement);
        }
    }

    @Override
    public void updateWatched(Watched oldWatched, Watched newWatched) {
        Connection connection =  MSSQLDatabase.getConnection();
        PreparedStatement preparedStatement = null;

        //Finalize query
        try{
            String sqlQuery = "UPDATE Accounts SET  name = ?, seen = ?, percentage = ? WHERE subscriptionId = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);

            //Index 1 or 0?

            preparedStatement.setString(1, newWatched.getName());
            preparedStatement.setInt(2, newWatched.getSeen());
            preparedStatement.setInt(3, newWatched.getPercentage());
            preparedStatement.setInt(4, newWatched.getId());

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeStatementResources(preparedStatement);
        }
    }

    @Override
    public void deleteWatched(Watched deleteWatch) {
        Connection connection =  MSSQLDatabase.getConnection();
        Statement statement = null;

        //Finalize with parameter query
        try{
            String sqlQuery = "DELETE FROM Watched WHERE subscriptionId " + deleteWatch.getId();
            statement = connection.createStatement();
            statement.execute(sqlQuery);
        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeStatementResources(statement);
        }
    }


}

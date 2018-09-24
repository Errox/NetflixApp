package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.SerieDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Episode;
import DomainModelLayer.Profile;
import DomainModelLayer.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SqlServerSerieDAO implements SerieDAO {

    //[SerieId] [int] IDENTITY(1,1) NOT NULL,
    //[Name] [nvarchar](50) NULL,
    //[age] [int] NULL,
    //[Language] [nvarchar](50) NULL,
    //[Genre] [nvarchar](50) NULL,
    private MSSQLHelper MSSQLDatabase;

    public SqlServerSerieDAO() {
        this.MSSQLDatabase = new MSSQLHelper();
    }

    @Override
    public List<Serie> getAllSeries() {
        Connection connection =  MSSQLDatabase.getConnection();
        List<Serie> Series = new ArrayList<Serie>();
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            String sqlQuery = "SELECT * FROM Series";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){

                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                int Age = resultSet.getInt("Age");
                String Language = resultSet.getString("Language");
                String Genre = resultSet.getString("Genre");
                Series.add(new Serie(id, name, Age, Language, Genre));
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement);
        }

        return Series;
    }

    @Override
    public Serie getSerieById(int id) {
        Connection connection =  MSSQLDatabase.getConnection();
        Serie serie = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            statement = connection.prepareStatement("SELECT * FROM Series WHERE Id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while(resultSet.next()){

                int SerieId = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                int Age = resultSet.getInt("Age");
                String Language = resultSet.getString("Language");
                String Genre = resultSet.getString("Genre");

                //Add our account from db to list.
                serie = new Serie(id, name, Age, Language, Genre);
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return serie;
    }

    @Override
    public int getAvarageWatchTime(Profile profile, Serie series) {
        Connection connection =  MSSQLDatabase.getConnection();
        int count = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Episode> episodes =  series.getAllEpisodes();
        try{
        for (Episode episode: episodes) {
            try{
                statement = connection.prepareStatement("SELECT Watched.Percentage as avarage FROM  Episodes INNER JOIN Profiles ON Episodes.Id = Profiles.Id INNER JOIN Programs ON Episodes.ProgramId = Programs.Id INNER JOIN Watched ON Profiles.Id = Watched.ProfileId AND Programs.Id = Watched.ProgramId WHERE Profiles.Id = ? and Episodes.Id = ?");
                statement.setInt(1, profile.getId());
                statement.setInt(2, episode.getId());
                resultSet = statement.executeQuery();

                while(resultSet.next()){
                    count += resultSet.getInt("avarage");
                }

            }catch (Exception e) {
                //Print on error.
                e.printStackTrace();
            }

        }
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return count/episodes.size();
    }


}

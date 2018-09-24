package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.EpisodeDAO;
import DataStorageLayer.Factories.DAOFactory;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Episode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqlServerEpisodeDAO implements EpisodeDAO {

    private MSSQLHelper MSSQLDatabase;

    public SqlServerEpisodeDAO() {
        this.MSSQLDatabase = new MSSQLHelper();
    }

    @Override
    public List<Episode> getAllEpisodes() {
        Connection connection =  MSSQLDatabase.getConnection();
        List<Episode> Episodes = new ArrayList<Episode>();
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            String sqlQuery = "SELECT * FROM Episodes";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){

                int id = resultSet.getInt("Id");
                int EpisodeNr = resultSet.getInt("EpisodeNr");
                int SeasonNr = resultSet.getInt("SeasonNr");
                int ProgramId = resultSet.getInt("ProgramId");
                int SerieId = resultSet.getInt("SerieId");
                Episodes.add(new Episode(id, EpisodeNr, SeasonNr, ProgramId, SerieId));
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement);
        }

        return Episodes;
    }

    @Override
    public Episode getEpisodeById(int id) {
        Connection connection =  MSSQLDatabase.getConnection();
        Episode episode = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            statement = connection.prepareStatement("SELECT * FROM Episodes WHERE Id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while(resultSet.next()){

                int episodeId = resultSet.getInt("Id");
                int EpisodeNr = resultSet.getInt("EpisodeNr");
                int SeasonNr = resultSet.getInt("SeasonNr");
                int ProgramId = resultSet.getInt("ProgramId");
                int SerieId = resultSet.getInt("SerieId");

                episode = new Episode(id, EpisodeNr, SeasonNr, ProgramId, SerieId);
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return episode;
    }

}

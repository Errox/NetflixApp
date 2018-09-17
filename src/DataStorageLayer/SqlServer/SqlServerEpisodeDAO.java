package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.EpisodeDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Episode;

import java.sql.Connection;
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
        List<Episode> episodes = new ArrayList<Episode>();
        List<Map<String, Object>> queryResult =  null; //SqlHelperResultSet.getInstance().execRawQuery("SELECT * FROM Episode");

        for (int i = 0; i < queryResult.size(); i++){
            //Store separately to Map to get values.
            Map<String, Object> objectMap = queryResult.get(i);

            //Case Sensitively retrieving by column name.
            //Should be by reflection.
            Episode episode = new Episode("", 1, 1 );

            episodes.add(episode);
        }

        return episodes;
    }

    @Override
    public Episode getEpisodeById(int id) {
        Connection connection =  MSSQLDatabase.getConnection();
        Episode episode = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            String sqlQuery = "";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){
//
//                int subscriptionId = resultSet.getInt("subscriptionId");
//                String name = resultSet.getString("name");
//                String streetName = resultSet.getString("streetName");
//                String postalCode = resultSet.getString("postalCode");
//                String houseNumber = resultSet.getString("houseNumber");
//                String place = resultSet.getString("place");

                //Add our account from db to list.
                episode =null;//new Episode(subscriptionId, name, streetName, postalCode, houseNumber, place);
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

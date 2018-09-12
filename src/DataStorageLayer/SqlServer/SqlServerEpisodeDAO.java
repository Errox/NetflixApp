package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.EpisodeDAO;
import DomainModelLayer.Episode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlServerEpisodeDAO implements EpisodeDAO {

    @Override
    public List<Episode> getAllEpisodes() {
        List<Episode> episodes = new ArrayList<Episode>();
        List<Map<String, Object>> queryResult =  null; //SqlHelperResultSet.getInstance().execRawQuery("SELECT * FROM Episode");

        for (int i = 0; i < queryResult.size(); i++){
            //Store separately to Map to get values.
            Map<String, Object> objectMap = queryResult.get(i);

            //Case Sensitively retrieving by column name.
            //Should be by reflection.
            Episode episode = new Episode("");

            episodes.add(episode);
        }

        return episodes;
    }

    @Override
    public Episode getEpisodeById(int id) {
        return null;
    }

}

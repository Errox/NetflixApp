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

    @Override
    public void addEpisodes(List<Episode> newEpisodes) {
//        for (Episode episode: newEpisodes) {
//            SqlHelperResultSet.getInstance().execCreatebyVal("Episode",
//                    episode.getSeason());
//        }
    }

    @Override
    public void updateEpisode(Episode oldEpisode, Episode newEpisode) {
        Map<String, Object> changed = new HashMap<>();

        changed.put("season", newEpisode.getSeason());

        Map<String, Object> old = new HashMap<>();
        old.put("season", oldEpisode.getSeason());

//        SqlHelperResultSet.getInstance().execUpdateByVal("Episode", changed, old);
    }

    @Override
    public void deleteEpisode(List<Episode> deleteEpisodes) {

//        for(Episode deleteEpisode : deleteEpisodes){
//            SqlHelperResultSet.getInstance().executeQuery(
//                    "DELETE Account WHERE season = "
//                            + deleteEpisodes.getSubscriptionNumber());
//        }

    }
}

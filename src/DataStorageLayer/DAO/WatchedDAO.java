package DataStorageLayer.DAO;

import DomainModelLayer.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface WatchedDAO {
    List<Watched> getAllWatched();

    Watched getWatchedById(int id);

    List<Watched> getAllWatchedForProfile(Profile profile);

    void addWatched(Watched newWatched);

    void updateWatched(Watched oldWatched, Watched newWatched);

    void deleteWatched(Watched deleteWatch);

    List<Integer> getWatchedTimeForEpisodesBySerieOfAccount(Account account, Serie serie);
    Map<Episode,Integer> getWatchedTimeForEpisodes(List<Episode> episodes);

}

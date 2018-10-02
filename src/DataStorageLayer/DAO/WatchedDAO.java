package DataStorageLayer.DAO;

import DomainModelLayer.Account;
import DomainModelLayer.Profile;
import DomainModelLayer.Serie;
import DomainModelLayer.Watched;

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

    List<Integer> getWatchedTimeForEpisodesBySerie(Account account, Serie serie);
}

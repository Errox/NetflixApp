package DataStorageLayer.DAO;

import DomainModelLayer.Watched;

import java.util.List;

public interface WatchedDAO  {
    List<Watched> getAllWatched();
    Watched getWatchedById(int id);

    void addWatched(Watched newWatched);
    void updateWatched(Watched oldWatched, Watched newWatched);
    void deleteWatched(Watched deleteWatch);
}

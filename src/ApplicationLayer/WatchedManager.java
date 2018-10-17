package ApplicationLayer;

import DataStorageLayer.DAO.WatchedDAO;
import DataStorageLayer.Factories.DAOFactory;
import DomainModelLayer.*;

import java.util.List;
import java.util.Map;

public class WatchedManager implements WatchedDAO {

    private WatchedDAO watchedDAO;

    /**
     * Creates an instance of the watched Manager,
     * that uses the Dao specified in the constructor to
     * -Create
     * -Read
     * -Update
     * -Delete
     */

    public WatchedManager() {
        this.watchedDAO = DAOFactory.getWatchedDAOInstance();
    }

    /**
     * -Returns all watched by the data storage layer provided.
     */
    @Override
    public List<Watched> getAllWatched() {
        return watchedDAO.getAllWatched();
    }

    /**
     * -Returns watched associated by the provided id, from the storage layer provided.
     */
    @Override
    public Watched getWatchedById(int id) {
        return watchedDAO.getWatchedById(id);
    }

    @Override
    public List<Watched> getAllWatchedForProfile(Profile profile) {
        return watchedDAO.getAllWatchedForProfile(profile);
    }

    /**
     * -Adds an watched to the data storage layer provided
     *
     * @param newWatched represents the new 'watched' that will be added to the Data storage
     */
    @Override
    public int addWatched(Watched newWatched) {
       return watchedDAO.addWatched(newWatched);
    }

    /**
     * -Updates an watched by specifying the new and old watched.
     * Old watched is used to find the 'old '- watched
     * so we can replace those values within the Data storage
     */
    @Override
    public void updateWatched(Watched newWatched, Watched oldWatched) {
        watchedDAO.updateWatched(oldWatched, newWatched);
    }

    /**
     * -Deletes an watched by specifying the to be deleted watched(s).
     * <p>
     * "as of type List, it is easier to implement both delete / delete (multiple)
     * then representing both methods as maintainable"
     */
    @Override
    public void deleteWatched(Watched deleteWatch) {
        watchedDAO.deleteWatched(deleteWatch);
    }


    @Override
    public List<Integer> getWatchedTimeForEpisodesBySerieOfAccount(Account account, Serie serie) {
        return watchedDAO.getWatchedTimeForEpisodesBySerieOfAccount(account, serie);
    }

    @Override
    public Map<Episode, Integer> getWatchedTimeForEpisodes(List<Episode> episodes) {
        return watchedDAO.getWatchedTimeForEpisodes(episodes);
    }

}

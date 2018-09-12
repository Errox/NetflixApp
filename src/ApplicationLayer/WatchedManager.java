package ApplicationLayer;

import DataStorageLayer.DAO.WatchedDAO;
import DomainModelLayer.Watched;

import java.util.List;

public class WatchedManager {

    private WatchedDAO watchedDAO;

    /**
     * Creates an instance of the watched Manager,
     * that uses the Dao specified in the constructor to
     * -Create
     * -Read
     * -Update
     * -Delete
     * @param  dao the DAO that meets the contract.
     */

    public WatchedManager(WatchedDAO dao){
        this.watchedDAO = dao;
    }

     /**
     * -Returns all watched by the data storage layer provided.
      * */
    public List<Watched> getAllWatched(){
        return watchedDAO.getAllWatched();
    }


    /**
     * -Returns watched associated by the provided id, from the storage layer provided.
     * */
    public Watched getWatchedById(int id){
        return watchedDAO.getWatchedById(id);
    }

    /**
    * -Adds an watched to the data storage layer provided
     * @param newWatched represents the new 'watched' that will be added to the Data storage
    */
    public void addWatched(Watched newWatched){
        watchedDAO.addWatched(newWatched);
    }

     /**
     * -Updates an watched by specifying the new and old watched.
      * Old watched is used to find the 'old '- watched
      * so we can replace those values within the Data storage
     */
    public void updateWatched(Watched newWatched, Watched oldWatched){
        watchedDAO.updateWatched(oldWatched, newWatched);
    }

    /**
     * -Deletes an watched by specifying the to be deleted watched(s).
     *
     * "as of type List, it is easier to implement both delete / delete (multiple)
     * then representing both methods as maintainable"
     */
    public void deleteWatched(Watched deleteWatched){
        watchedDAO.deleteWatched(deleteWatched);
    }

}

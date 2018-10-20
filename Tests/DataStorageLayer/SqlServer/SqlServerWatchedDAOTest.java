package DataStorageLayer.SqlServer;

import ApplicationLayer.WatchedManager;
import DomainModelLayer.Watched;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqlServerWatchedDAOTest {


    @Test
    public void TestWatchedStoredMatchesObjectReturned() {

        WatchedManager watchedManager = new WatchedManager();
        Watched toBeAddedToDatabase = new Watched(0, 99, 1, 1);

        int id = watchedManager.addWatched(toBeAddedToDatabase);

        Watched retrievedFromDatabase = watchedManager.getWatchedById(id);

        //Won't evaluate as true, as the id is unknown on object creation, it is assigned by the dbs.
        assertEquals(retrievedFromDatabase, toBeAddedToDatabase);

    }

    @Test
    public void WatchedCanBeDeletedFromDatabase() {

        WatchedManager watchedManager = new WatchedManager();
        Watched toBeAddedToDatabase = new Watched(0, 99, 1, 1);

        int id = watchedManager.addWatched(toBeAddedToDatabase);

        Watched retrievedFromDatabase = watchedManager.getWatchedById(id);

        watchedManager.deleteWatched(retrievedFromDatabase);
        assertEquals(null, watchedManager.getWatchedById(id));


    }
    @Test
    public void UpdateWatchedWithCorrectOldWatched() {
        WatchedManager watchedManager = new WatchedManager();
        Watched toBeAddedToDatabase = new Watched(0, 99, 1, 1);

        int id = watchedManager.addWatched(toBeAddedToDatabase);

        Watched Updated = new Watched(0, 69, 1, 1);
        watchedManager.updateWatched(Updated,toBeAddedToDatabase);
        Watched retrievedFromDatabase = watchedManager.getWatchedById(id);

        assertNotEquals(retrievedFromDatabase, Updated);
    }

}
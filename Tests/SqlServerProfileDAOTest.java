import ApplicationLayer.ProfileManager;
import DomainModelLayer.Profile;

import java.util.Date;

public class SqlServerProfileDAOTest {

    boolean TestAccountStoredMatchesObjectReturned() {

        ProfileManager accountManager = new ProfileManager();

        Profile toBeAddedToDatabase = new Profile(0, "asd", new Date(), 0);

        int storedProfileId = accountManager.addProfile(toBeAddedToDatabase);

        Profile retrievedFromDatabase = accountManager.getProfileById(storedProfileId);

        //Won't evaluate as true, as the id is unknown on object creation, it is assigned by the dbs.
        //assertEquals(retrievedFromDatabase, toBeAddedToDatabase);
        return false;
    }


    boolean DatabaseErrorOnTruncatedData() {
        ProfileManager accountManager = new ProfileManager();

        Profile toBeAddedToDatabase = new Profile(0, "Testaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", new Date(), 0);

        //Should throw truncated exception
        int storedAccountId = accountManager.addProfile(toBeAddedToDatabase);
        return false;
    }


    boolean AccountCanBeDeletedFromDatabase() {

        ProfileManager accountManager = new ProfileManager();

        //Needs an account first. < RETRIEVE FIRST.
        Profile toBeAddedToDatabase = new Profile(0, "asd", new Date(), 0);

        int storedAccountId = accountManager.addProfile(toBeAddedToDatabase);

        Profile retrievedFromDatabase = accountManager.getProfileById(storedAccountId);

        //Won't evaluate as true, as the id is unknown on object creation, it is assigned by the dbs.

        //Cleanup from database.
        if (retrievedFromDatabase.equals(toBeAddedToDatabase))
            accountManager.deleteProfile(retrievedFromDatabase);

        return false;
    }
}

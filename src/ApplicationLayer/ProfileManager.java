package ApplicationLayer;

import DataStorageLayer.DAO.ProfileDAO;
import DataStorageLayer.Factories.DAOFactory;
import DomainModelLayer.Profile;

import java.awt.color.ProfileDataException;
import java.util.List;

public class ProfileManager implements ProfileDAO {

    private ProfileDAO profileDAO;

    /**
     * Creates an instance of the Profile Manager,
     * that uses the Dao specified in the constructor to
     * -Create
     * -Read
     * -Update
     * -Delete
     */

    public ProfileManager(){
        this.profileDAO = DAOFactory.getProfileDAOInstance();
    }

    /**
     * -Returns all Profiles by the data storage layer provided.
     * */
    @Override
    public List<Profile> getAllProfiles(){

        return profileDAO.getAllProfiles();
    }

    /**
     * -Returns Profile associated by the provided id, from the storage layer provided.
     * */
    @Override
    public Profile getProfileById(int id){
        return profileDAO.getProfileById(id);
    }

    /**
     * -Adds an profile to the data storage layer provided
     * @param newProfile represents the new 'Account' that will be added to the Data storage
     */
    @Override
    public void addProfile(Profile newProfile){
        profileDAO.addProfile(newProfile);
    }

    /**
     * -Updates an profile by specifying the new and old profile.
     * Old profile is used to find the 'old '- profile
     * so we can replace those values within the Data storage
     */
    @Override
    public void updateProfile(Profile newProfile, Profile oldProfile){
        profileDAO.updateProfile(oldProfile, newProfile);
    }

    /**
     * -Deletes an Profile by specifying the to be deleted profile.
     */
    @Override
    public void deleteProfile(Profile deleteProfile){
        profileDAO.deleteProfile(deleteProfile);
    }
}

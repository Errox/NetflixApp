package ApplicationLayer;

import DataStorageLayer.DAO.ProfileDAO;
import DomainModelLayer.Profile;

import java.util.List;

public class ProfileManager {

    private ProfileDAO profileDAO;

    /**
     * Creates an instance of the Profile Manager,
     * that uses the Dao specified in the constructor to
     * -Create
     * -Read
     * -Update
     * -Delete
     * @param  dao the DAO that meets the contract.
     */

    public ProfileManager(ProfileDAO dao){
        this.profileDAO = dao;
    }

    /**
     * -Returns all Profiles by the data storage layer provided.
     * */
    public List<Profile> getAllAccounts(){

        return profileDAO.getAllProfiles();
    }

    /**
     * -Returns Profile associated by the provided id, from the storage layer provided.
     * */
    public Profile getProfileById(int id){
        return profileDAO.getProfileById(id);
    }

    /**
     * -Adds an profile to the data storage layer provided
     * @param newProfile represents the new 'Account' that will be added to the Data storage
     */
    public void addAccount(Profile newProfile){
        profileDAO.addProfiles(newProfile);
    }

    /**
     * -Updates an profile by specifying the new and old profile.
     * Old profile is used to find the 'old '- profile
     * so we can replace those values within the Data storage
     */
    public void updateAccount(Profile newProfile, Profile oldProfile){
        profileDAO.updateProfile(oldProfile, newProfile);
    }

    /**
     * -Deletes an Profile by specifying the to be deleted profile.
     */
    public void deleteAccount(Profile deleteProfile){
        profileDAO.deleteProfiles(deleteProfile);
    }
}

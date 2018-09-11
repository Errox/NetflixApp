package DataStorageLayer.DAO;

import DomainModelLayer.Profile;

import java.util.List;

public interface ProfileDAO {
    List<Profile> getAllAccounts();
    Profile getProfileById(int id);

    void addProfiles(List<Profile> newProfiles);
    void updateProfile(Profile oldProfile, Profile newProfile);
    void deleteProfiles(List<Profile> deleteProfiles);
}

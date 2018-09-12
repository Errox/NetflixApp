package DataStorageLayer.DAO;

import DomainModelLayer.Profile;

import java.util.List;

public interface ProfileDAO {
    List<Profile> getAllProfiles();
    Profile getProfileById(int id);

    void addProfiles(Profile newProfiles);
    void updateProfile(Profile oldProfile, Profile newProfile);
    void deleteProfiles(Profile deleteProfile);
}

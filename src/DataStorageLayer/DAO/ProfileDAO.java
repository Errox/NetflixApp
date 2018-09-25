package DataStorageLayer.DAO;

import DomainModelLayer.Account;
import DomainModelLayer.Profile;

import java.util.List;

public interface ProfileDAO {
    List<Profile> getAllProfiles();

    List<Profile> getProfilesFromOwner(Account owner);

    Profile getProfileById(int id);

    int getProfileCount(Account owner);

    void addProfile(Profile newProfiles);

    void updateProfile(Profile oldProfile, Profile newProfile);

    void deleteProfile(Profile deleteProfile);
}

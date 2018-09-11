package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.ProfileDAO;
import DomainModelLayer.Profile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SqlServerProfileDAO implements ProfileDAO {

    //[SubscriptionNumber] [int] NOT NULL,
    //[Name] [nvarchar](50) NOT NULL,
    //[Birthdate] [date] NULL,

    @Override
    public List<Profile> getAllAccounts() {
        List<Profile> profiles = new ArrayList<Profile>();
        List<Map<String, Object>> queryResult = null; //SqlHelperResultSet.getInstance().execRawQuery("SELECT * FROM Profile");

        for (int i = 0; i < queryResult.size(); i++){
            //Store separately to Map to get values.
            Map<String, Object> objectMap = queryResult.get(i);

            //Case Sensitively retrieving by column name.
            //Should be by reflection.
            Profile profile = new Profile("", new Date());

            profiles.add(profile);
        }

        return profiles;
    }

    @Override
    public Profile getProfileById(int id) {
        return null;
    }

    @Override
    public void addProfiles(List<Profile> newProfiles) {

    }

    @Override
    public void updateProfile(Profile oldProfile, Profile newProfile) {

    }

    @Override
    public void deleteProfiles(List<Profile> deleteProfiles) {

    }
}

package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.WatchedDAO;
import DomainModelLayer.Watched;

import java.util.List;

public class SqlServerWatchedDAO implements WatchedDAO {

    //[SubscriptionNumber] [int] NOT NULL,
    //[Name] [nvarchar](50) NOT NULL,
    //[Seen] [int] NOT NULL,
    //[Watched] [int] NULL,


    @Override
    public List<Watched> getAllWatched() {
        return null;
    }

    @Override
    public Watched getWatchedById(int id) {
        return null;
    }


}

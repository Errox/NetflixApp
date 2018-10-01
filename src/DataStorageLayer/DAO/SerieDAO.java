package DataStorageLayer.DAO;

import DomainModelLayer.Account;
import DomainModelLayer.Profile;
import DomainModelLayer.Serie;

import java.util.List;

public interface SerieDAO {
    List<Serie> getAllSeries();

    Serie getSerieById(int id);

    int getAverageWatchTime(Profile profile, Serie series);

    int getWatchedTimeForSerie(Account account);
}

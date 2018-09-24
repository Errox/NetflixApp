package DataStorageLayer.DAO;

import DomainModelLayer.Profile;
import DomainModelLayer.Serie;

import java.util.List;

public interface SerieDAO {
    List<Serie> getAllSeries();
    Serie getSerieById(int id);
    int getAvarageWatchTime(Profile profile, Serie series);

}

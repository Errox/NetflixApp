package DataStorageLayer.DAO;

import DomainModelLayer.Serie;

import java.util.List;

public interface SerieDAO {
    List<Serie> getAllSeries();
    Serie getSerieById(int id);

    void addSeries(List<Serie> newAccounts);
    void updateSerie(Serie oldAccount, Serie newAccount);
    void deleteSerie(List<Serie> deleteAccounts);
}

package ApplicationLayer;

import DataStorageLayer.DAO.SerieDAO;
import DataStorageLayer.Factories.DAOFactory;
import DomainModelLayer.Profile;
import DomainModelLayer.Serie;

import java.util.List;

public class SerieManager implements SerieDAO {

    private SerieDAO serieDAO;

    /**
     * Creates an instance of the serie Manager,
     * that uses the Dao specified in the constructor to
     * -Read
     */

    public SerieManager() {
        this.serieDAO = DAOFactory.getSerieDAOInstance();
    }

    /**
     * -Returns all serie by the data storage layer provided.
     */
    @Override
    public List<Serie> getAllSeries() {
        return serieDAO.getAllSeries();
    }


    /**
     * -Returns serie associated by the provided id, from the storage layer provided.
     */
    @Override
    public Serie getSerieById(int id) {
        return serieDAO.getSerieById(id);
    }

    @Override
    public int getAvarageWatchTime(Profile profile, Serie series) {
        return serieDAO.getAvarageWatchTime(profile, series);
    }


}

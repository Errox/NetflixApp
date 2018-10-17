package ApplicationLayer;

import DataStorageLayer.DAO.SerieDAO;
import DataStorageLayer.Factories.DAOFactory;
import DomainModelLayer.Serie;

import java.util.List;

public class SerieManager implements SerieDAO {

    private SerieDAO serieDAO;

    /**
     * Creates an instance of the Serie Manager,
     * that uses the Dao specified in the constructor to
     * -Read all
     * -Read by ID
     * -Get avg watch time ( for profile and serie )
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

    /**
     * -Get avg watch time ( for profile and serie )
     * @param profile profile,
     * @param series serie
     * @return int as watch time. in minutes
     */
}

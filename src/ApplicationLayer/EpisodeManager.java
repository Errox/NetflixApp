package ApplicationLayer;

import DataStorageLayer.DAO.EpisodeDAO;
import DataStorageLayer.Factories.DAOFactory;
import DomainModelLayer.Episode;

import java.util.List;

public class EpisodeManager implements EpisodeDAO {

    private EpisodeDAO episodeDAO;

    /**
     * Creates an instance of the Episode Manager,
     * that uses the Dao specified in the constructor to
     * -Read all
     * -Read  by ID
     * -Read all by serie Id
     */
    public EpisodeManager() {
        this.episodeDAO = DAOFactory.getEpisodeDAOInstance();
    }

    /**
     * -Returns all Episodes, from the storage layer provided.
     */
    @Override
    public List<Episode> getAllEpisodes() {
        return episodeDAO.getAllEpisodes();
    }

    /**
     * -Returns the Episode associated by the provided id, from the storage layer provided.
     */
    @Override
    public Episode getEpisodeById(int id) {
        return episodeDAO.getEpisodeById(id);
    }

    @Override
    public Episode getEpisodeByProgramId(int id) {
        return episodeDAO.getEpisodeByProgramId(id);
    }

    /**
     * -Returns get All Episodes by series id , from the storage layer provided.
     */
    @Override
    public List<Episode> getAllEpisodesBySeriesId(int id) {
        return episodeDAO.getAllEpisodesBySeriesId(id);
    }
}

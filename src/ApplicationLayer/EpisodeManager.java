package ApplicationLayer;

import DataStorageLayer.DAO.EpisodeDAO;
import DataStorageLayer.Factories.DAOFactory;
import DomainModelLayer.Episode;

import java.util.List;

public class EpisodeManager implements EpisodeDAO {

    private EpisodeDAO episodeDAO;

    public EpisodeManager() {
        this.episodeDAO = DAOFactory.getEpisodeDAOInstance();
    }

    @Override
    public List<Episode> getAllEpisodes() {
        return episodeDAO.getAllEpisodes();
    }

    @Override
    public Episode getEpisodeById(int id) {
        return episodeDAO.getEpisodeById(id);
    }

    @Override
    public List<Episode> getAllEpisodesBySeriesId(int id) {
        return episodeDAO.getAllEpisodesBySeriesId(id);
    }
}

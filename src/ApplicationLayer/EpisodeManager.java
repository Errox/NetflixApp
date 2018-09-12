package ApplicationLayer;

import DataStorageLayer.DAO.EpisodeDAO;
import DomainModelLayer.Episode;

import java.util.List;

public class EpisodeManager implements EpisodeDAO {

    private EpisodeDAO episodeDAO;

    public EpisodeManager(EpisodeDAO episodeDAO){
        this.episodeDAO = episodeDAO;
    }

    @Override
    public List<Episode> getAllEpisodes() {
        return null;
    }

    @Override
    public Episode getEpisodeById(int id) {
        return null;
    }
}

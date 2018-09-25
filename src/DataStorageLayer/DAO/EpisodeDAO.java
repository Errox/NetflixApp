package DataStorageLayer.DAO;

import DomainModelLayer.Episode;

import java.util.List;

public interface EpisodeDAO {
    List<Episode> getAllEpisodes();

    Episode getEpisodeById(int id);

    List<Episode> getAllEpisodesBySeriesId(int id);
}

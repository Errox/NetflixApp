package DataStorageLayer.DAO;

import DomainModelLayer.Episode;

import java.util.List;

public interface EpisodeDAO {
    List<Episode> getAllEpisodes();
    Episode getEpisodeById(int id);

    void addEpisodes(List<Episode> newEpisodes);
    void updateEpisode(Episode oldEpisode, Episode newEpisode);
    void deleteEpisode(List<Episode> deleteEpisodes);
}

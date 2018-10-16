package PresentationLayer.Panels;

import ApplicationLayer.EpisodeManager;
import ApplicationLayer.ProgramManager;
import ApplicationLayer.SerieManager;
import ApplicationLayer.WatchedManager;
import DomainModelLayer.Episode;
import DomainModelLayer.Program;
import DomainModelLayer.Serie;
import PresentationLayer.EventHandlers.SyncManager;
import PresentationLayer.EventHandlers.lForSelectingSerieWatched;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class SeriesWatchedPanel extends JPanel implements SyncManager {
    JComboBox serieBox = new JComboBox();
    private DefaultListModel defaultListModel;

    public SeriesWatchedPanel() {
        //2. Voor een door de gebruiker geselecteerde serie, geef per aflevering het gemiddeld bekeken % van de tijdsduur. Bij elke aflevering worden het volgnummer én titel getoond.

        defaultListModel = new DefaultListModel();
        JList list = new JList(defaultListModel);
        setLayout(new GridLayout(10, 1, 10, 10));
        SerieManager serieManager = new SerieManager();

        JLabel label = new JLabel();
        //movie.addActionListener(new lForMovieWatchedTotal(movie, label));


        serieBox.setModel(new DefaultComboBoxModel(serieManager.getAllSeries().toArray()));
        serieBox.addActionListener(new lForSelectingSerieWatched(this));
        serieBox.setSelectedIndex(0);
        add(serieBox);
        add(label);
        add(list);

    }

    public void update() {
        EpisodeManager episodeManager = new EpisodeManager();
        if (defaultListModel != null)
            defaultListModel.clear();
        java.util.List<Episode> episodes;
        Serie serie = (Serie) serieBox.getSelectedItem();
        episodes = episodeManager.getAllEpisodesBySeriesId(serie.getId());

        WatchedManager watchedManager = new WatchedManager();

        Map<Episode, Integer> episodesWatched = watchedManager.getWatchedTimeForEpisodes(episodes);
        for (Episode episode : episodes) {
            int avg = 0;
            if (episodesWatched.get(episode) != null) {
                avg = episodesWatched.get(episode);
            }

            Program program = new ProgramManager().getProgramById(episode.getProgramId());
            defaultListModel.addElement(episode + " " + program.getTitle() + " " + avg + "% Watched");
        }

    }
}

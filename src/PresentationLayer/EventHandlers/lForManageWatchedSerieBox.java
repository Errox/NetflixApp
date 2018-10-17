package PresentationLayer.EventHandlers;

import ApplicationLayer.EpisodeManager;
import DomainModelLayer.Serie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForManageWatchedSerieBox implements ActionListener {

    private JComboBox movieOrSerie, EpisodeBox, SerieOrMovieBox;

    public lForManageWatchedSerieBox(JComboBox movieOrSerie, JComboBox EpisodeBox, JComboBox SerieOrMovieBox){
        this.movieOrSerie = movieOrSerie;
        this.EpisodeBox = EpisodeBox;
        this.SerieOrMovieBox = SerieOrMovieBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!movieOrSerie.getSelectedItem().equals("Movie")) {
            EpisodeManager episodeManager = new EpisodeManager();
            EpisodeBox.setModel(new DefaultComboBoxModel(episodeManager.getAllEpisodesBySeriesId(((Serie) SerieOrMovieBox.getSelectedItem()).getId()).toArray()));
        }
    }
}

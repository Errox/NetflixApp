package PresentationLayer.EventHandlers;

import ApplicationLayer.MovieManager;
import ApplicationLayer.SerieManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForManageWatchedMovieOrSerie implements ActionListener {

    private JComboBox movieOrSerie;
    private JComboBox serieOrMovieBox;
    private JComboBox episodeBox;
    private JLabel episodesLabel;

    public lForManageWatchedMovieOrSerie(JComboBox movieOrSerie, JComboBox serieOrMovieBox, JComboBox episodeBox, JLabel episodesLabel) {
        this.movieOrSerie = movieOrSerie;
        this.serieOrMovieBox = serieOrMovieBox;
        this.episodeBox = episodeBox;
        this.episodesLabel = episodesLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (movieOrSerie.getSelectedItem().equals("Movie")) {
            MovieManager movieManager = new MovieManager();
            serieOrMovieBox.setModel(new DefaultComboBoxModel(movieManager.getAllMovies().toArray()));
            episodeBox.setVisible(false);
            episodesLabel.setVisible(false);

        } else {
            SerieManager serieManager = new SerieManager();
            serieOrMovieBox.setModel(new DefaultComboBoxModel(serieManager.getAllSeries().toArray()));
            episodeBox.setVisible(true);
            episodesLabel.setVisible(true);

        }
    }
}

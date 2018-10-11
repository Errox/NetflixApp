package PresentationLayer.EventHandlers;

import ApplicationLayer.MovieManager;
import DomainModelLayer.Movie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForMovieWatchedTotal implements ActionListener {


    private final JComboBox jComboBox;
    private JLabel labelFinished;
    private JLabel labelStillWatching;

    public lForMovieWatchedTotal(JComboBox jComboBox, JLabel labelFinished, JLabel labelStillWatching) {
        this.jComboBox = jComboBox;
        this.labelFinished = labelFinished;
        this.labelStillWatching = labelStillWatching;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Movie movie = (Movie) jComboBox.getSelectedItem();
        MovieManager movieManager = new MovieManager();

        int finishedCount = movieManager.getFinishedCount(movie);

        int stillWatching = movieManager.getStillWatchingCount(movie);

        labelFinished.setText("Fully watched " + finishedCount + " Times");
        labelStillWatching.setText(stillWatching + " haven't finished it and are still watching");

    }
}
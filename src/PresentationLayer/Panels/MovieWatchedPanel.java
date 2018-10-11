package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.MovieManager;
import ApplicationLayer.WatchedManager;
import DomainModelLayer.Account;
import DomainModelLayer.Movie;
import PresentationLayer.EventHandlers.lForMovieWatchedTotal;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MovieWatchedPanel extends JPanel {

    //6. Voor een door de gebruiker geselecteerde film, hoeveel kijkers hebben deze in z’n geheel bekeken

    public MovieWatchedPanel() {
        setLayout(new GridLayout(10, 1, 10, 10));
        MovieManager movieManager = new MovieManager();
        JComboBox movie = new JComboBox();
        JLabel labelFinished = new JLabel();
        JLabel labelStillWatching = new JLabel();
        movie.addActionListener(new lForMovieWatchedTotal(movie, labelFinished, labelStillWatching));

        movie.setModel(new DefaultComboBoxModel(movieManager.getAllMovies().toArray()));

        movie.setSelectedIndex(0);
        add(movie);
        add(labelFinished);
        add(labelStillWatching);
    }
}
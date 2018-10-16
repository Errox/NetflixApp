package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.MovieManager;
import ApplicationLayer.WatchedManager;
import DomainModelLayer.Account;
import DomainModelLayer.Movie;
import PresentationLayer.EventHandlers.SyncManager;
import PresentationLayer.EventHandlers.lForMovieWatchedTotal;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MovieWatchedPanel extends JPanel implements SyncManager {

    //6. Voor een door de gebruiker geselecteerde film, hoeveel kijkers hebben deze in z’n geheel bekeken

    private MovieManager movieManager;
    private DefaultComboBoxModel model;
    private JComboBox movie;

    public MovieWatchedPanel() {
        setLayout(new GridLayout(10, 1, 10, 10));
        movieManager = new MovieManager();

        movie = new JComboBox();
        JLabel labelFinished = new JLabel();
        JLabel labelStillWatching = new JLabel();
        movie.addActionListener(new lForMovieWatchedTotal(movie, labelFinished, labelStillWatching));

        model = new DefaultComboBoxModel(movieManager.getAllMovies().toArray());

        movie.setModel(model);

        movie.setSelectedIndex(0);
        add(movie);
        add(labelFinished);
        add(labelStillWatching);
    }

    @Override
    public void update() {
        Runnable runnable =
                () -> { movie.setModel(new DefaultComboBoxModel(movieManager.getAllMovies().toArray())); };
        runnable.run();

    }
}
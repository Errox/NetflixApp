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

        WatchedManager watchedManager = new WatchedManager();
        MovieManager movieManager = new MovieManager();

        List<Movie> movieList = movieManager.getAllMovies();
        add(new JComboBox<>(movieList.toArray()));


        //Use the watched manager to "gebruiker geselecteerde film, hoeveel kijkers hebben deze in z’n geheel bekeken"

        JList list = new JList();
        add(list);
    }
}

package PresentationLayer.Panels;

import ApplicationLayer.MovieManager;
import PresentationLayer.EventHandlers.lForMovieWatchedTotal;

import javax.swing.*;
import java.awt.*;

public class MovieWatchedPanel extends JPanel {

    public MovieWatchedPanel(){
        this.setLayout(new GridLayout(10, 1, 10, 10));
        MovieManager movieManager = new MovieManager();
        JComboBox movie = new JComboBox();
        JLabel label = new JLabel();
        movie.addActionListener(new lForMovieWatchedTotal(movie, label));


        movie.setModel(new DefaultComboBoxModel(movieManager.getAllMovies().toArray()));

        movie.setSelectedIndex(0);
        add(movie);
        add(label);
    }
}

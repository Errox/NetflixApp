package PresentationLayer.EventHandlers;

import ApplicationLayer.MovieManager;
import DomainModelLayer.Movie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForMovieWatchedTotal implements ActionListener {


    private final JComboBox jComboBox;
    private JLabel label;

    public lForMovieWatchedTotal(JComboBox jComboBox, JLabel label) {
        this.jComboBox = jComboBox;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Movie movie = (Movie) jComboBox.getSelectedItem();
        MovieManager movieManager = new MovieManager();
        int finishedCount = movieManager.getFinishedCount(movie);
        DefaultListModel listModel = new DefaultListModel();
        label.setText("Fully watched " + finishedCount + " Times");
    }
}
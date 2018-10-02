package PresentationLayer.EventHandlers;

import ApplicationLayer.MovieManager;
import ApplicationLayer.ProgramManager;
import ApplicationLayer.WatchedManager;
import DomainModelLayer.Movie;
import DomainModelLayer.Profile;
import DomainModelLayer.Watched;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
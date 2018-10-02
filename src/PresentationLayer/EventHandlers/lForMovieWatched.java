package PresentationLayer.EventHandlers;

import ApplicationLayer.MovieManager;
import ApplicationLayer.ProgramManager;
import ApplicationLayer.WatchedManager;
import DomainModelLayer.Movie;
import DomainModelLayer.MovieProgram;
import DomainModelLayer.Profile;
import DomainModelLayer.Watched;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class lForMovieWatched implements ActionListener {


    private final JComboBox jComboBox;
    private JList list;

    public lForMovieWatched(JComboBox jComboBox, JList list) {
        this.jComboBox = jComboBox;
        this.list = list;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        Profile profile = (Profile) jComboBox.getSelectedItem();
        MovieManager movieManager = new MovieManager();
        WatchedManager watchedManager = new WatchedManager();
        List<Watched> watched = watchedManager.getAllWatchedForProfile(profile);
        ProgramManager programManager = new ProgramManager();
        List<Movie> movies = new ArrayList<Movie>();
        for (Watched watch: watched) {
            movies.add( movieManager.getMovieByProgramId(watch.getProgramId()));
        }


        DefaultListModel listModel = new DefaultListModel();

        listModel.addElement(movies);

        list.setModel(listModel);
    }
}

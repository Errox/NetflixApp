package PresentationLayer.Panels;

import ApplicationLayer.MovieManager;
import DomainModelLayer.Movie;

import javax.swing.*;
import java.awt.*;

public class MoviePanel extends JPanel {


    public MoviePanel(){
        //ToDo; implement On change, and call the manager to update the datamodel of the JLIST.

        JComboBox ageSelector = new JComboBox();
        MovieManager movieManager = new MovieManager();

        //1-16 as age.
        for ( int i = 1 ; i < 17; i++) {
            ageSelector.addItem(i);
        }

        int selectedAge = Integer.parseInt(ageSelector.getSelectedItem().toString());
        Movie movie = movieManager.getLongestMovieForAge(selectedAge);

        DefaultListModel listModel = new DefaultListModel();

        if(movie != null)
            listModel.addElement(movie.toString());

        JList list = new JList(listModel);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        add(ageSelector);
        add(list);
    }
}

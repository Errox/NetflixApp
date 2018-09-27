package PresentationLayer.Panels;

import ApplicationLayer.MovieManager;
import DomainModelLayer.Movie;

import javax.swing.*;
import java.awt.*;

public class MoviePanel extends JPanel {


    public MoviePanel(){

        //ToDo; implement On change, and call the manager to update the datamodel of the JLIST.
        //Query works.

        JComboBox ageSelector = new JComboBox();

        //1-16 as age.
        for ( int i = 1 ; i < 17; i++) {
            ageSelector.addItem(i);
        }


        MovieManager movieManager = new MovieManager();
        Movie movie = movieManager.getLongestMovieForAge(Integer.parseInt(ageSelector.getSelectedItem().toString()));

        DefaultListModel listModel = new DefaultListModel();

        if(movie != null)
            listModel.addElement(movie.toString());

        JList list = new JList(listModel);

        //list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //list.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        add(ageSelector);
        add(list);
    }
}

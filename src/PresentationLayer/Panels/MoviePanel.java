package PresentationLayer.Panels;

import ApplicationLayer.MovieManager;
import DomainModelLayer.Movie;
import PresentationLayer.EventHandlers.LForMovieList;

import javax.swing.*;
import java.awt.*;

public class MoviePanel extends JPanel {


    public MoviePanel(){
        //ToDo; implement On change, and call the manager to update the datamodel of the JLIST.

        JComboBox ageSelector = new JComboBox();
        JList list = new JList();
        ageSelector.addActionListener(new LForMovieList(ageSelector, list));


        //1-16 as age.
        for ( int i = 1 ; i < 17; i++) {
            ageSelector.addItem(i);
        }




        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        add(ageSelector);
        add(list);
    }
}

package PresentationLayer.Panels;

import PresentationLayer.EventHandlers.lForMovieList;

import javax.swing.*;
import java.awt.*;

public class MoviePanel extends JPanel {

    public MoviePanel(){
        JComboBox ageSelector = new JComboBox();
        JList list = new JList();
        ageSelector.addActionListener(new lForMovieList(ageSelector, list));

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

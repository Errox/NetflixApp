package PresentationLayer.EventHandlers;

import ApplicationLayer.MovieManager;
import DomainModelLayer.Movie;
import DomainModelLayer.MovieProgram;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LForMovieList implements ActionListener {

    private JComboBox comboBox;
    private JList list;

    //To Interface
    public LForMovieList(JComboBox comboBox, JList list){
        this.comboBox = comboBox;
        this.list = list;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int selectedAge = Integer.parseInt(comboBox.getSelectedItem().toString());
        MovieManager movieManager = new MovieManager();

        MovieProgram movie = movieManager.getLongestMovieForAge(selectedAge);

        DefaultListModel listModel = new DefaultListModel();

        if(movie != null)
            listModel.addElement(movie.toString());

        list.setModel(listModel);
    }
}

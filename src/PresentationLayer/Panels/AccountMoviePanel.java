package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.MovieManager;
import DomainModelLayer.Account;
import PresentationLayer.EventHandlers.lForMovieWatchedTotal;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//Op deze panel kan er een account worden gekozen er word dan weergegeven welke films er door dit account zijn bekeken + percentage

public class AccountMoviePanel extends JPanel {

    //3. Welke films zijn er door een door de gebruiker geselecteerd account bekeken?


    public AccountMoviePanel() {

        setLayout(new GridLayout(10, 1, 10, 10));
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


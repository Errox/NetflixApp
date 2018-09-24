package PresentationLayer.Panels;

import javax.swing.*;
import java.awt.*;

public class SeriesPanel extends JPanel {
    int age = 0;


    public SeriesPanel(){

        SeriesContainer();

    }

    public void SeriesContainer(){

        setLayout(new BorderLayout());
        setSize(250, 100);
        JLabel imgLabel = new JLabel(new ImageIcon("netflix-icon.png"));
        JLabel title = new JLabel("Title: Serie");
        JLabel age = new JLabel("Age : 2");
        JLabel language = new JLabel("Language : GERMAN");
        JLabel genre = new JLabel("Genre : POPofzo");

        add(title, BorderLayout.NORTH);
        add(imgLabel, BorderLayout.WEST);
        add(age, BorderLayout.CENTER);
        add(language, BorderLayout.EAST);
        add(genre, BorderLayout.SOUTH);

    }
}

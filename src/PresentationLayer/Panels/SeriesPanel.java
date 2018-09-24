package PresentationLayer.Panels;

import javax.swing.*;
import java.awt.*;

public class SeriesPanel extends JPanel {


    public SeriesPanel(){
        add(SeriesContainer());
    }


    public Panel SeriesContainer(){
        Panel p = new Panel();

        p.setLayout(new BorderLayout());
        p.setSize(300, 200);
        JLabel imgLabel = new JLabel(new ImageIcon("netflix-icon.png"));
        JLabel title = new JLabel("Title: Serie");
        JLabel age = new JLabel("Age : 2");
        JLabel language = new JLabel("Language : GERMAN");
        JLabel genre = new JLabel("Genre : POPofzo");

        p.add(title, BorderLayout.NORTH);
        p.add(imgLabel, BorderLayout.WEST);
        p.add(age, BorderLayout.CENTER);
        p.add(language, BorderLayout.EAST);
        p.add(genre, BorderLayout.SOUTH);

        return p;
    }
}

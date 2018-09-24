package PresentationLayer.Panels;

import ApplicationLayer.SerieManager;

import javax.swing.*;
import java.awt.*;

public class SeriesPanel extends JPanel {

    public SeriesPanel(){
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        panel.setSize(1250, 200);

        JScrollPane pane = new JScrollPane(panel);

        for(int i=1; i<11; i++) {
            pane.add(SeriesContainer(i, "GERMANEESES", "Knetter Kaas", "Pop"));
        }



    }

    public JPanel SeriesContainer(int Age, String Language, String Title, String Genre){
        JPanel p = new JPanel();

        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setSize(new Dimension(200, 200));
        p.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        JLabel imgLabel = new JLabel(new ImageIcon("netflix-icon.png"));
        JLabel title = new JLabel("Title: " + Title);
        JLabel age = new JLabel("Age : " + Age);
        JLabel language = new JLabel("language : " + Language);
        JLabel genre = new JLabel("Genre : " + Genre);
        p.add(title);
        p.add(imgLabel);
        p.add(age);
        p.add(language);
        p.add(genre);


        return p;
    }
}

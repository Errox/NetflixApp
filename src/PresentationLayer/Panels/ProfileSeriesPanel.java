package PresentationLayer.Panels;

import ApplicationLayer.SerieManager;

import javax.swing.*;
import java.awt.*;

public class ProfileSeriesPanel extends JPanel {
    public ProfileSeriesPanel(){

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setSize(1250, 200);

        SerieManager sm = new SerieManager();
        //For loop over all series.


        add(ProfileSeriesContainer(20, "GERMANEESES", "Knetter Kaas", "Pop" ));

        add(ProfileSeriesContainer(20, "GERMAN", "Knetter Kaas DEEL 2000", "Pop" ));

        add(ProfileSeriesContainer(20, "GERMAN", "Knetter Kaas", "Pop2000000000" ));

    }

    public JPanel ProfileSeriesContainer(int Age, String Language, String Title, String Genre){
        JPanel p = new JPanel();

        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setSize(new Dimension(5000, 200));
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

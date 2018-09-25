package PresentationLayer.Panels;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    public InfoPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1280, 25));

        JLabel title = new JLabel("Netflix Statistix");
        JLabel info = new JLabel("Informatica 2018/2019 Klas: 23VK  Ryan Groenewold, Dennis Blokland, Sjoerd Teunisse");

        add(title, BorderLayout.WEST);
        add(info, BorderLayout.EAST);

        title.setForeground(Color.lightGray);
        info.setForeground(Color.lightGray);
        setBackground(Color.gray.darker().darker().darker());
    }
}

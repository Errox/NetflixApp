package PresentationLayer;

import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Panels.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

import static com.sun.glass.ui.Cursor.setVisible;

public class MainForm implements Runnable {
    private JFrame f;

    public void SetVisualDefaults() {
        f = new JFrame();

        f.setSize(1280, 720);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        URL imageURL = getClass().getClassLoader().getResource("netflix-icon.png");
        f.setIconImage(Toolkit.getDefaultToolkit().getImage(imageURL));
        f.setTitle(ControlNames.APPLICATION_NAME);
    }

    @Override
    public void run() {

        SetVisualDefaults();
        MainPanel mainPanel = new MainPanel();
        f.setVisible(true);
        f.add(mainPanel);
    }
}

package PresentationLayer;

import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Panels.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MainForm extends JFrame {

    public MainForm(){
        new SplashScreen().initialize();

        SetVisualDefaults();
        MainPanel mainPanel = new MainPanel();
        setVisible(true);
        add(mainPanel);
    }

    public void SetVisualDefaults(){
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        URL imageURL = getClass().getClassLoader().getResource("netflix-icon.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(imageURL));
        setTitle(ControlNames.APPLICATION_NAME);
    }
}

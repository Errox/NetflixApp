package PresentationLayer;

import PresentationLayer.Panels.MainPanel;

import javax.swing.*;

public class MainForm extends JFrame {

    public MainForm(){
        new SplashScreen().initialize();

        SetVisualDefaults();

        MainPanel mainPanel = new MainPanel();
        //LoadingPanel loadingPanel = new LoadingPanel();

        //add(loadingPanel);
        setVisible(true);
        //Thread.sleep(5000);
        //remove(loadingPanel);

        add(mainPanel);
        //revalidate();
        //repaint();
    }

    public void SetVisualDefaults(){
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Netflix Statistix");
    }
}

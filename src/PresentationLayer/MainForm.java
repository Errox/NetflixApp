package PresentationLayer;

import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Panels.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MainForm implements Runnable {
    private JFrame jFrame;

    public void SetVisualDefaults() {
        jFrame = new JFrame();

        jFrame.setSize(1280, 720);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        URL imageURL = getClass().getClassLoader().getResource(ControlNames.APPLICATION_ICON);
        jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(imageURL));
        jFrame.setTitle(ControlNames.APPLICATION_NAME);
    }

    @Override
    public void run() {
        SetVisualDefaults();
        MainPanel mainPanel = new MainPanel();
        jFrame.setVisible(true);
        jFrame.add(mainPanel);
    }
}

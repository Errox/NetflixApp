package PresentationLayer;

import javax.swing.*;
import java.net.URL;

public class SplashScreen {

    private JWindow jWindow;

    public void initialize(){
        jWindow = new JWindow();
        jWindow.setSize(680, 316);
        jWindow.setLocationRelativeTo(null);
        jWindow.requestFocus();

        URL imageURL = getClass().getClassLoader().getResource("netflix-logo.png");

        jWindow.getContentPane().add(new JLabel("", new ImageIcon(imageURL), SwingConstants.CENTER));

        jWindow.setVisible(true);
        try {
            //Maybe warm up the database connection / cache in this time?
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jWindow.setVisible(false);
        jWindow.dispose();
    }
}

package PresentationLayer;

import javax.swing.*;
import java.net.URL;

public class SplashScreen extends JWindow{

    public void initialize(){
        setSize(680, 316);
        setLocationRelativeTo(null);
        requestFocus();

        URL imageURL = getClass().getClassLoader().getResource("netflix-logo.png");

        getContentPane().add(new JLabel("", new ImageIcon(imageURL), SwingConstants.CENTER));

        setVisible(true);
        try {
            //Maybe warm up the database connection / cache in this time?
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setVisible(false);
        dispose();
    }
}

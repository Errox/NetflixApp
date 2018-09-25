import PresentationLayer.MainForm;
import PresentationLayer.SplashScreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new SplashScreen().initialize();
        SwingUtilities.invokeLater(new MainForm());
    }
}

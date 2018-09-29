import PresentationLayer.MainForm;
import PresentationLayer.SplashScreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Initialize the splashscreen.
        new SplashScreen().initialize();
        //Call invokelater to start a new Instance of MainForm
        SwingUtilities.invokeLater(new MainForm());
    }
}

package PresentationLayer;

import DataStorageLayer.Helpers.MSSQLHelper;

import javax.swing.*;
import java.net.URL;

public class SplashScreen {

    private JWindow jWindow;

    //Splash Screen delegates, the creation of tables DB and TABLES.

    public void beforeInitialize(){
        MSSQLHelper.initializeGetConnectionString();
        MSSQLHelper.setConnection();

        if(MSSQLHelper.suggestNoDatabaseExists()){
            int dialogResult = JOptionPane.showConfirmDialog(null, "No database found on the DBServer, would u like to create it automatically?", "SQL Server (DB not found).", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                MSSQLHelper.createDatabase();
                MSSQLHelper.setConnection();
            } else {
                System.exit(0);
            }
        }

        if (MSSQLHelper.suggestProvisionOnEmptyDB()) {

            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like sample data?", "No data detected in DB", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                MSSQLHelper.provision();
            } else {
                System.exit(0);
            }
        }
    }

    public void initialize() {
        beforeInitialize();
        jWindow = new JWindow();
        jWindow.setSize(680, 316);
        //Center
        jWindow.setLocationRelativeTo(null);
        //Force front
        jWindow.requestFocus();

        URL imageURL = getClass().getClassLoader().getResource("netflix-logo.png");

        jWindow.getContentPane().add(new JLabel("", new ImageIcon(imageURL), SwingConstants.CENTER));

        jWindow.setVisible(true);
        try {
            //Maybe warm up the database connection / cache in this time?
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Hide
        jWindow.setVisible(false);
        //Dispose resource.
        jWindow.dispose();
    }
}

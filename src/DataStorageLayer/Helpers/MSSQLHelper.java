package DataStorageLayer.Helpers;

import PresentationLayer.Controls.ControlNames;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MSSQLHelper {
    private static String connectionString = "";
    private static Connection connection;

    public Connection getConnection() {
        try {
            getConnectionString();
            connection = DriverManager.getConnection(connectionString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error Occurred in MSSQLHelper", JOptionPane.ERROR_MESSAGE);
        }

        return connection;
    }

    public void getConnectionString() {
        File f = new File("src\\DataStorageLayer\\SqlServer\\connectionString.txt");

        try {
            Scanner s = new Scanner(f);

            if (!s.hasNextLine()) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "No connection string found in DataStorageLayer\\SqlServer\\connectionString.txt would u like to open the file?", ControlNames.CONFIRM_TITLE_ERROR, JOptionPane.YES_NO_OPTION);

                if (dialogResult == JOptionPane.YES_OPTION) {
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().edit(f);
                    }

                }
                System.exit(0);
            } else {
                connectionString = s.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeResources(ResultSet resultSet, Statement statement) {
        closeStatementResources(statement);
        closeResultSetResources(resultSet);
    }

    public void closeResources(ResultSet resultSet, Statement statement, Connection connection) {
        closeStatementResources(statement);
        closeResultSetResources(resultSet);
        closeConnectionResource(connection);
    }

    public void closeConnectionResource(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception ignore) {

            }
        }
    }

    public void closeStatementResources(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception ignore) {

            }
        }
    }

    public void closeResultSetResources(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception ignore) {

            }
        }
    }
}
package DataStorageLayer.Helpers;

import DataStorageLayer.SqlServer.SqlDemoData;
import PresentationLayer.Controls.ControlNames;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MSSQLHelper {
    private static final String dbName = ";databaseName=NetFlixStats;";
    private static final String dbSecurity = "integratedSecurity=true";

    private static String connectionString = "";
    private static Connection connection;

    public static void setConnection() {
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initializeGetConnectionString() {
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

    public static boolean suggestProvisionOnEmptyDB() {
        Statement statement = null;
        ResultSet resultSet = null;
        //It was set again.
        // initializeGetConnectionString();

        ArrayList<Integer> rowCount = new ArrayList<Integer>();
        String DBSMDquery = "USE NetFlixStats; SELECT  [Name] = o.name " +
                " , [RowCount]  = SUM(p.row_count)" +
                " FROM    SYS.DM_DB_PARTITION_STATS p" +
                " INNER JOIN" +
                " SYS.TABLES o\n" +
                " ON p.[object_ID] = o.[object_id]\n" +
                " WHERE   index_id    <= 1 \n" +
                " GROUP BY o.name\n" +
                " ORDER   BY 2 desc";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DBSMDquery);

            while (resultSet.next()) {
                rowCount.add(resultSet.getInt("RowCount"));
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        }

        return rowCount.stream().mapToInt(Integer::intValue).sum() == 0 ? true : false;
    }

    public static boolean suggestNoDatabaseExists() {
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Integer> rowCount = new ArrayList<Integer>();
        String DBSMDquery = "DECLARE @dbname nvarchar(20) " +
                "SET @dbname = N'NetflixStats' " +
                "IF (EXISTS (SELECT name " +
                "FROM master.dbo.sysdatabases " +
                "WHERE ('[' + name + ']' = @dbname " +
                "OR name = @dbname))) " +
                "PRINT 'db exists'";

        try {
            statement = connection.createStatement();
            statement.execute(DBSMDquery);
            SQLWarning warning = statement.getWarnings();

            while (warning != null) {
                if (warning.equals("db exists"))
                    return true;
                else
                    return false;
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        }

        //Where I != 0 return true, else false.
        return rowCount.stream().mapToInt(Integer::intValue).sum() == 0 ? true : false;
    }

    public static void provision() {

        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.execute(SqlDemoData.getAccountDemoData());
            statement.execute(SqlDemoData.getProfileDemoData());
            statement.execute(SqlDemoData.getProgramDemoData());
            statement.execute(SqlDemoData.getMovieDemoData());
            statement.execute(SqlDemoData.getSerieDemoData());
            statement.execute(SqlDemoData.getEpisodeDemoData());
            statement.execute(SqlDemoData.getWatchedDemoData());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void executeSqlScript(Connection conn, File inputFile) {

        // Delimiter
        String delimiter = ";";

        // Create scanner
        Scanner scanner;
        try {
            scanner = new Scanner(inputFile).useDelimiter(delimiter);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return;
        }

        // Loop through the SQL file statements
        Statement currentStatement = null;
        while (scanner.hasNext()) {

            // Get statement
            String rawStatement = scanner.next() + delimiter;
            try {
                // Execute statement
                currentStatement = conn.createStatement();
                currentStatement.execute(rawStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Release resources
                if (currentStatement != null) {
                    try {
                        currentStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                currentStatement = null;
            }
        }
        scanner.close();
    }

    public static void createDatabase() {
        File f = new File("Assignment\\CreateDBSQL.txt");

        executeSqlScript(connection, f);

        File connectionString = new File("src\\DataStorageLayer\\SqlServer\\connectionString.txt");

        try {
            Scanner c = new Scanner(connectionString);
            //Null?
            String currentConnection = c.nextLine();
            String[] host = currentConnection.split(";");
            String securityPart = dbSecurity;
            String newConnection = "";

            newConnection += host[0];
            newConnection += dbName;
            newConnection += securityPart;

            FileWriter fileWriter = new FileWriter(connectionString);

            fileWriter.write(newConnection);
            fileWriter.flush();
            fileWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        try {
            initializeGetConnectionString();
            setConnectionString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error Occurred in MSSQLHelper", JOptionPane.ERROR_MESSAGE);
        }

        return connection;
    }

    private void setConnectionString() {
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
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
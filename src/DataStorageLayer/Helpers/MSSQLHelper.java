package DataStorageLayer.Helpers;

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

        return rowCount.stream().mapToInt(Integer::intValue).sum() == 0 ? true : false;
    }

    public static void provision() {
        String provisionAccountSQL =
                "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Edward Porter', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                        "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Oliver Spencer' , '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                        "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Harrison Hudson', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                        "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Josh Cole', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                        "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Reuben Ryan', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                        "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Amy Stacy', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                        "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Amber Jefferson', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                        "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Jill Williams', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                        "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Alexandra Ness', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                        "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Alexis Amazon', '14216 Rusk Avenue', 1633, '1633', 'Haixing');";

        String provisionProfileSQL =
                "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Edward Porter', '09/11/1922', 1);" +
                        "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Oliver Spencer', '09/09/1983', 2);" +
                        "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Harrison Hudson', '09/02/1973', 3);" +
                        "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Josh Cole', '09/03/1963', 4);" +
                        "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Reuben Ryan', '09/05/1953', 5);" +
                        "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Amy Stacy', '09/06/1943', 6);" +
                        "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Amber Jefferson', '08/02/1923', 7);" +
                        "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Jill Williams', '09/09/1991', 8);" +
                        "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Alexandra Ness', '09/02/1993', 9);" +
                        "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Alexis Amazon', '09/08/1995', 10);";

        String provisionProgramsSQL =
                "insert INTO Programs (Title, Duration) values ('Better Call Saul', '22:59');" +
                        "insert INTO Programs (Title, Duration) values ('Game of Thrones', '22:59');" +
                        "insert INTO Programs (Title, Duration) values ('Stranger Things', '22:59');" +
                        "insert INTO Programs (Title, Duration) values ('Sherlock', '22:59');" +
                        "insert INTO Programs (Title, Duration) values ('Orange is the New Black', '22:59');" +
                        "insert INTO Programs (Title, Duration) values ('Forrest Gump', '02:12');" +
                        "insert INTO Programs (Title, Duration) values ('The Godfather', '02:23');" +
                        "insert INTO Programs (Title, Duration) values ('Alien: Covenant', '02:35');" +
                        "insert INTO Programs (Title, Duration) values ('The Lord of the Rings', '03:00');" +
                        "insert INTO Programs (Title, Duration) values ('Saving private ryan', '03:12');";


        String provisionSeriesSQL =
                "insert INTO Series (Name, Age, Genre, Language) values ('Better Call Saul', 9, 'Comedy', 'English');" +
                        "insert INTO Series (Name, Age, Genre, Language) values ('Game of Thrones', 16, 'Action', 'English');" +
                        "insert INTO Series (Name, Age, Genre, Language) values ('Stranger Things', 12, 'Thriller | Action', 'English');" +
                        "insert INTO Series (Name, Age, Genre, Language) values ('Sherlock', 9, 'Drama | Action', 'English');" +
                        "insert INTO Series (Name, Age, Genre, Language) values ('Orange is the New Black', 12, 'Action | Drama', 'English');";

        String provisionEpisodesSQL =
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 1, 1);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 1, 1);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 1, 1);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (4, 1, 1, 1);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (5, 1, 1, 1);" +

                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 2, 2);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 2, 2);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 2, 2);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (4, 1, 2, 2);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (5, 1, 2, 2);" +

                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 3, 3);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 3, 3);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 3, 3);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (4, 1, 3, 3);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (5, 1, 3, 3);" +

                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 4, 4);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 4, 4);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 4, 4);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (4, 1, 4, 4);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (5, 1, 4, 4);" +

                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 5, 5);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 5, 5);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 5, 5);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (4, 1, 5, 5);" +
                        "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (5, 1, 5, 5);";


        String provisionMoviesSQL =
                "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (12, 'English', 'Drama', 6);" +
                        "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (12, 'English', 'Action', 7);" +
                        "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (16, 'English', 'Action | Crime', 8);" +
                        "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (12, 'English', 'Action | Drama', 9);" +
                        "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (12, 'English', 'Action | War', 10);";

        //Write a loop for this below.

        //Test this loop
        String provisionString = "";
        Random rnd = new Random();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; i++) {
                int c = rnd.nextInt(100);
                provisionString += "insert INTO Watched (Percentage, ProfileId, ProgramId) values (" + c + ","+ j + ","+ i + ");";
            }
        }

        String provisionWatched =
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 1);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 1);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 1);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 1);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 1);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 1);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 1);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 1);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 1);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 1);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 2);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 2);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 2);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 2);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 2);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 2);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 2);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 2);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 2);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 2);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 3);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 3);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 3);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 3);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 3);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 3);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 3);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 3);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 3);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 3);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 4);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 4);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 4);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 4);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 4);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 4);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 4);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 4);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 4);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 4);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 5);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 5);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 5);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 5);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 5);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 5);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 5);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 5);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 5);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 5);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 6);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 6);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 6);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 6);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 6);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 6);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 6);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 6);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 6);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 6);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 6);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 6);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 7);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 7);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 7);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 7);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7,7);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 7);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 7);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 7);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 8);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 8);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 8);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 8);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 8);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 8);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 8);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 8);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 8);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 8);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 9);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 9);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 9);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 9);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 9);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 9);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 9);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 9);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 9);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 9);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 10);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 10);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 10);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 10);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 10);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 10);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 10);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 10);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 10);" +
                        "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 10);";


        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.execute(provisionAccountSQL);
            statement.execute(provisionProfileSQL);
            statement.execute(provisionProgramsSQL);
            statement.execute(provisionMoviesSQL);
            statement.execute(provisionSeriesSQL);
            statement.execute(provisionEpisodesSQL);
            statement.execute(provisionWatched);

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

            String securityPart = "integratedSecurity=true";
            String withoutIntegrated = currentConnection.substring(currentConnection.length() - ("integratedSecurity=true").length());

            String newConnection = "";

            newConnection += host[0];
            newConnection += ";databaseName=NetFlixStats;";
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
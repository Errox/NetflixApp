package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.MovieDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlServerMovieDAO implements MovieDAO {

    private MSSQLHelper MSSQLDatabase;

    public SqlServerMovieDAO() {
        this.MSSQLDatabase = new MSSQLHelper();
    }

    //[MovieId] [int] NOT NULL,
    //[AgeClassification] [int] NULL,
    //[Language] [nvarchar](50) NULL,
    //[Genre] [nvarchar](50) NULL,

    //ToDO; Redudant code to seperate methods.

    @Override
    public List<Movie> getAllMovies() {
        Connection connection = MSSQLDatabase.getConnection();
        List<Movie> Movies = new ArrayList<Movie>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            String sqlQuery = "SELECT * FROM Series";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {

                int id = resultSet.getInt("Id");
                int Age = resultSet.getInt("AgeIndication");
                String Language = resultSet.getString("ProgramId");
                String Genre = resultSet.getString("Genre");
                Movies.add(new Movie(id, Age, Language, Genre));
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement);
        }

        return Movies;
    }

    @Override
    public Movie getMovieById(int id) {
        Connection connection = MSSQLDatabase.getConnection();
        Movie movie = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM Movies WHERE Id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int movieId = resultSet.getInt("Id");
                int Age = resultSet.getInt("AgeIndication");
                String Language = resultSet.getString("ProgramId");
                String Genre = resultSet.getString("Genre");

                movie = new Movie(movieId, Age, Language, Genre);
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return movie;
    }

    @Override
    public Movie getLongestMovieForAge(int age) {
        Connection connection = MSSQLDatabase.getConnection();
        Movie movie = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //statement = connection.prepareStatement("SELECT * FROM Movies WHERE Id = ?");
            statement = connection.prepareStatement("SELECT TOP 1 Programs.Title,Duration   FROM Programs JOIN Movies ON Movies.Id = Programs.Id  " +
                    " WHERE AgeIndication < ? " +
                    " ORDER BY Duration DESC; ");

            statement.setInt(1, age);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int movieId = resultSet.getInt("Id");
                int Age = resultSet.getInt("AgeIndication");
                String Language = resultSet.getString("ProgramId");
                String Genre = resultSet.getString("Genre");

                movie = new Movie(movieId, Age, Language, Genre);
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return movie;

       // "SELECT TOP 1 Programma.Titel,Tijdsduur\n" +
        //                        "FROM Programma JOIN Film ON Film.FilmID = Programma.ProgrammaID\n" +
        //                        "WHERE Leeftijdsindicatie < 16\n" +
        //                        "ORDER BY Tijdsduur DESC;");
    }

}

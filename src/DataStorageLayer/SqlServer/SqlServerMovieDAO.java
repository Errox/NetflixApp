package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.MovieDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Account;
import DomainModelLayer.Movie;
import DomainModelLayer.MovieProgram;
import DomainModelLayer.Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public MovieProgram getLongestMovieForAge(int age) {
        Connection connection = MSSQLDatabase.getConnection();
        MovieProgram movieProgram = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");


        try {
            statement = connection.prepareStatement("SELECT TOP 1 Programs.Title,Programs.Duration, Programs.Id as ProgramId, Movies.AgeIndication, Movies.Genre, Movies.Id as MovieId, Movies.Language FROM Programs JOIN Movies ON Movies.ProgramId = Programs.Id " +
                    " WHERE AgeIndication <= ?" +
                    " ORDER BY Duration DESC");

            statement.setInt(1, age);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int movieId = resultSet.getInt("MovieId");
                int ageIndication = resultSet.getInt("AgeIndication");
                String language = resultSet.getString("Language");
                String genre = resultSet.getString("Genre");

                int programId = resultSet.getInt("ProgramId");
                String programTitle = resultSet.getString("Title");
                String programTimeSpan = resultSet.getString("Duration");

                try {
                    date = df.parse(programTimeSpan);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Movie movie = new Movie(movieId, ageIndication, language, genre);
                Program program = new Program(programId, programTitle, date);

                movieProgram = new MovieProgram(movie, program);

            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return movieProgram;
    }


}

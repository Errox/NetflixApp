package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.MovieDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SqlServerMovieDAO implements MovieDAO {

    private MSSQLHelper MSSQLDatabase;

    public SqlServerMovieDAO() {
        this.MSSQLDatabase = new MSSQLHelper();
    }
    //ToDO; Redudant code to seperate methods.
    @Override
    public List<Movie> getAllMovies() {
        Connection connection = MSSQLDatabase.getConnection();
        List<Movie> Movies = new ArrayList<Movie>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            String sqlQuery = "SELECT * FROM Movies";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {

                int id = resultSet.getInt("Id");
                int Age = resultSet.getInt("AgeIndication");
                int progamId = resultSet.getInt("ProgramId");
                String Genre = resultSet.getString("Genre");
                String language = resultSet.getString("Language");
                Movies.add(new Movie(id, Age, progamId, Genre,language));
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
                int programId = resultSet.getInt("ProgramId");
                String Genre = resultSet.getString("Genre");
                String language = resultSet.getString("Language");
                movie = new Movie(movieId, Age, programId, Genre, language);
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

                Movie movie = new Movie(movieId, ageIndication, programId, genre, language);
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


    @Override
    public int getFinishedCount(Movie movie) {
        Connection connection = MSSQLDatabase.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count =0;
        try {
            statement = connection.prepareStatement("SELECT count(Watched.Id) as count FROM  Movies INNER JOIN Programs ON Movies.ProgramId = Programs.Id INNER JOIN Watched ON Programs.Id = Watched.ProgramId AND Programs.Id = Watched.ProgramId WHERE Watched.Percentage = 100 and Movies.Id =?");
            statement.setInt(1, movie.getId());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return count;
    }

    @Override
    public int getStillWatchingCount(Movie movie) {
        Connection connection = MSSQLDatabase.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            statement = connection.prepareStatement("SELECT count(Watched.Id) as count FROM  Movies INNER JOIN Programs ON Movies.ProgramId = Programs.Id INNER JOIN Watched ON Programs.Id = Watched.ProgramId AND Programs.Id = Watched.ProgramId WHERE Watched.Percentage < 100 and Movies.Id =?");
            statement.setInt(1, movie.getId());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return count;
    }

    @Override
    public Map<String, String> getMoviesByAccountId(int id) {
        Connection connection = MSSQLDatabase.getConnection();
        Map<String, String> ProfileMovie = new HashMap<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer count = 0;
        try {
            statement = connection.prepareStatement("SELECT DISTINCT Profiles.Name as Name, Programs.Title as Title FROM Accounts INNER JOIN Movies ON Accounts.Id = Movies.Id INNER JOIN Profiles ON Accounts.Id = Profiles.AccountId INNER JOIN Programs ON Movies.ProgramId = Programs.Id INNER JOIN Watched ON Profiles.Id = Watched.ProfileId where Profiles.AccountId = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String ProfileName = resultSet.getString("Name");
                String MovieTitle = resultSet.getString("Title");
                ProfileMovie.put(ProfileName, MovieTitle);
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return ProfileMovie;


    }

}

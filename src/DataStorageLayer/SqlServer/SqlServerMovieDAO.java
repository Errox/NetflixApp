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
                String name = resultSet.getString("Name");
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
                String name = resultSet.getString("Name");
                int Age = resultSet.getInt("AgeIndication");
                String Language = resultSet.getString("ProgramId");
                String Genre = resultSet.getString("Genre");

                movie = new Movie(id, Age, Language, Genre);
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

}

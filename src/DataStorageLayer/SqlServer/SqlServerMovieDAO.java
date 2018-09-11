package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.MovieDAO;
import DomainModelLayer.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqlServerMovieDAO implements MovieDAO {

    //[MovieId] [int] NOT NULL,
    //[AgeClassification] [int] NULL,
    //[Language] [nvarchar](50) NULL,
    //[Genre] [nvarchar](50) NULL,

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> accounts = new ArrayList<Movie>();
        List<Map<String, Object>> queryResult = null; //SqlHelperResultSet.getInstance().execRawQuery("SELECT * FROM Movies");

        for (int i = 0; i < queryResult.size(); i++){
            //Store separately to Map to get values.
            Map<String, Object> objectMap = queryResult.get(i);

            //Case Sensitively retrieving by column name.
            //Should be by reflection.
            Movie movie = new Movie(1, "", "");

            accounts.add(movie);
        }
        return accounts;
    }

    @Override
    public Movie getMovieById(int id) {
        return null;
    }

    @Override
    public void addMovies(List<Movie> newMovies) {

    }

    @Override
    public void updateMovie(Movie oldMovie, Movie newMovie) {

    }

    @Override
    public void deleteMovies(List<Movie> deleteMovies) {

    }
}

package ApplicationLayer;

import DataStorageLayer.DAO.MovieDAO;
import DataStorageLayer.Factories.DAOFactory;
import DomainModelLayer.Movie;
import DomainModelLayer.MovieProgram;

import java.util.List;
import java.util.Map;

public class MovieManager implements MovieDAO {

    private MovieDAO movieDAO;

    public MovieManager() {
        this.movieDAO = DAOFactory.getMovieDAOInstance();
    }

    /**
     * -Returns Profile associated by the provided id, from the storage layer provided.
     */
    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    /**
     * -Returns Profile associated by the provided id, from the storage layer provided.
     */
    @Override
    public Movie getMovieById(int id) {
        return movieDAO.getMovieById(id);
    }

    /**
     * -Returns Profile associated by the provided id, from the storage layer provided.
     */
    @Override
    public MovieProgram getLongestMovieForAge(int age) {
       return movieDAO.getLongestMovieForAge(age);
    }

    /**
     * -Returns int counted users that finished the selected movie 100%.
     */
    @Override
    public int getFinishedCount(Movie movie) {
        return movieDAO.getFinishedCount(movie);
    }

    /**
     * -Returns int counted users that are still watching a selected movie.
     */
    @Override
    public int getStillWatchingCount(Movie movie) {
        return movieDAO.getStillWatchingCount(movie);
    }


    /**
     * - Returns every movie watched by a account ID
     */
    @Override
    public Map<String, String> getMoviesByAccountId(int id) {
        return movieDAO.getMoviesByAccountId(id);
    }


}

package ApplicationLayer;

import DataStorageLayer.DAO.MovieDAO;
import DataStorageLayer.Factories.DAOFactory;
import DomainModelLayer.Movie;
import DomainModelLayer.MovieProgram;

import java.util.List;

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

    @Override
    public int getFinishedCount(Movie movie) {
        return movieDAO.getFinishedCount(movie);
    }


}

package ApplicationLayer;

import DataStorageLayer.DAO.MovieDAO;
import DomainModelLayer.Movie;

import java.util.List;

public class MovieManager implements MovieDAO {

    private MovieDAO movieDAO;

    public MovieManager(MovieDAO movieDAO){
        this.movieDAO = movieDAO;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    @Override
    public Movie getMovieById(int id) {
        return movieDAO.getMovieById(id);
    }
}

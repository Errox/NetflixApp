package DataStorageLayer.DAO;

import DomainModelLayer.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> getAllMovies();

    Movie getMovieById(int id);
}

package DataStorageLayer.DAO;

import DomainModelLayer.Movie;
import DomainModelLayer.MovieProgram;

import java.util.List;

public interface MovieDAO {
    List<Movie> getAllMovies();

    Movie getMovieById(int id);

    MovieProgram getLongestMovieForAge(int age);
}

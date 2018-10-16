package DataStorageLayer.DAO;

import DomainModelLayer.Movie;
import DomainModelLayer.MovieProgram;

import java.util.List;
import java.util.Map;

public interface MovieDAO {
    List<Movie> getAllMovies();

    Movie getMovieById(int id);

    MovieProgram getLongestMovieForAge(int age);

    int getFinishedCount(Movie movie);

    int getStillWatchingCount(Movie movie);

    Map<String, String> getMoviesByAccountId(int id);
}
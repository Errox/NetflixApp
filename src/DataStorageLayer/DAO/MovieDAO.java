package DataStorageLayer.DAO;

import DomainModelLayer.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> getAllMovies();
    Movie getMovieById(int id);

    void addMovies(List<Movie> newMovies);
    void updateMovie(Movie oldMovie, Movie newMovie);
    void deleteMovies(List<Movie> deleteMovies);
}

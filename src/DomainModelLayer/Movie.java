package DomainModelLayer;

public class Movie {

    private int movieId;
    private int ageIndication;
    private String language;
    private String genre;

    public Movie(int movieId, int ageIdication, String language, String genre){
        this.movieId = movieId;
        this.ageIndication = ageIdication;
        this.language = language;
        this.genre = genre;
    }

    public Movie(int ageIndication, String language, String genre){
        this.ageIndication = ageIndication;
        this.language = language;
        this.genre = genre;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getAgeIdication() {
        return ageIndication;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }
}

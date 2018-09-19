package DomainModelLayer;

public class Movie {

    private int Id;
    private int ageIndication;
    private String language;
    private String genre;

    public Movie(int Id, int ageIndication, String language, String genre){
        this.Id = Id;
        this.ageIndication = ageIndication;
        this.language = language;
        this.genre = genre;
    }

    public Movie(int ageIndication, String language, String genre){
        this(0, ageIndication, language, genre);
    }

    public int getId() {
        return Id;
    }

    public int getAgeIndication() {
        return ageIndication;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }
}

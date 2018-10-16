package DomainModelLayer;

import ApplicationLayer.ProgramManager;

public class Movie {

    private int Id;
    private int ageIndication;
    private int progamId;
    private String genre;
    private String language;

    public Movie(int Id, int ageIndication, int progamId, String genre, String language) {
        this.Id = Id;
        this.ageIndication = ageIndication;
        this.progamId = progamId;
        this.genre = genre;
        this.language = language;
    }

    public Movie(int ageIndication, int progamId, String genre, String language) {
        this(0, ageIndication, progamId, genre, language);
    }

    public int getId() {
        return Id;
    }

    public int getAgeIndication() {
        return ageIndication;
    }

    public int getProgramId() {
        return progamId;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getTitle() {
        if (Id == 0) return "";
        ProgramManager programManager = new ProgramManager();
        String title = programManager.getProgramById(progamId).getTitle();
        if (title == null) return "";
        return title;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}

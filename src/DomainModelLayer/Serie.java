package DomainModelLayer;

import java.util.Date;

public class Serie {

    private int serieId;
    private String name;
    private int length;
    private String language;
    private String genre;

    public Serie(int serieId, String name, int length, String language, String genre){
            this.serieId = serieId;
            this.name = name;
            this.length = length;
            this.language = language;
            this.genre = genre;
    }

    public Serie(String name, int length, String language, String genre){
        this(0, name, length, language, genre);
    }


    public int getSerieId() {
        return serieId;
    }

    public String getName() {
        return name;
    }

    public int getLenght() {
        return length;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

}

package DomainModelLayer;

import java.util.Date;

public class Serie {

    private int serieId;
    private String name;
    private Date age;
    private String language;
    private String genre;
    private int looksLike;

    public Serie(int serieId, String name, Date age, String language, String genre){
            this.serieId = serieId;
            this.name = name;
            this.age = age;
            this.language = language;
            this.genre = genre;
    }

    public Serie(String name, Date age, String language, String genre){
        this.name = name;
        this.age = age;
        this.language = language;
        this.genre = genre;
    }


    public int getSerieId() {
        return serieId;
    }

    public String getName() {
        return name;
    }

    public Date getAge() {
        return age;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public int getLooksLike() {
        return looksLike;
    }
}

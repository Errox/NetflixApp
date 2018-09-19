package DomainModelLayer;

import java.util.Date;

public class Serie {

    private int Id;
    private String name;
    private int length;
    private String language;
    private String genre;

    public Serie(int Id, String name, int length, String language, String genre){
            this.Id = Id;
            this.name = name;
            this.length = length;
            this.language = language;
            this.genre = genre;
    }

    public Serie(String name, int length, String language, String genre){
        this(0, name, length, language, genre);
    }


    public int getId() {
        return Id;
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

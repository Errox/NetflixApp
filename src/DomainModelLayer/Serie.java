package DomainModelLayer;

import ApplicationLayer.EpisodeManager;

import java.util.List;

public class Serie {

    private int Id;
    private String name;
    private int age;
    private String language;
    private String genre;

    public Serie(int Id, String name, int age, String language, String genre) {
        this.Id = Id;
        this.name = name;
        this.age = age;
        this.language = language;
        this.genre = genre;
    }

    public Serie(String name, int age, String language, String genre) {
        this(0, name, age, language, genre);
    }


    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public List<Episode> getAllEpisodes() {
        EpisodeManager manager = new EpisodeManager();
        return manager.getAllEpisodesBySeriesId(this.Id);
    }

}

package DomainModelLayer;

public class Episode {

    private String season;
    private int episodeNr;
    private int seasonNr;

    public Episode(String season, int episodeNr, int seasonNr) {
        this.season = season;
        this.episodeNr = episodeNr;
        this.seasonNr = seasonNr;
    }

    public String getSeason() {
        return season;
    }

    public int getEpisodeNr() {
        return episodeNr;
    }

    public int getSeasonNr() {
        return seasonNr;
    }
}

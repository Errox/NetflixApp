package DomainModelLayer;

public class Episode {

    private int episodeNr;
    private int seasonNr;
    private int id;
    private int serieId;
    private int programId;

    public Episode(int id, int episodeNr, int seasonNr, int serieId, int programId) {
        this.id = id;
        this.episodeNr = episodeNr;
        this.seasonNr = seasonNr;
        this.serieId = serieId;
        this.programId = programId;
    }

    public int getId() {
        return id;
    }

    public int getProgramId() {
        return programId;
    }

    public int getSerieId() {
        return serieId;
    }

    public int getEpisodeNr() {
        return episodeNr;
    }

    public int getSeasonNr() {
        return seasonNr;
    }

    @Override
    public String toString() {
        return "Season " + seasonNr + ", Epsiode: " + episodeNr;
    }
}

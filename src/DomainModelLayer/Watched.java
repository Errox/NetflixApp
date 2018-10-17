package DomainModelLayer;

import ApplicationLayer.EpisodeManager;
import ApplicationLayer.MovieManager;
import ApplicationLayer.ProgramManager;

public class Watched {

    private int Id;
    private int profileId;
    private int programId;
    private int percentage;

    public Watched(int Id, int percentage, int programId, int profileId) {
        this.Id = Id;
        this.percentage = percentage;
        this.programId = programId;
        this.profileId = profileId;
    }

    public Watched(int percentage, int programId, int profileId) {
        this(0, percentage, programId, profileId);
    }

    public int getId() {
        return Id;
    }

    public int getPercentage() {
        return percentage;
    }

    public int getProfileId() {
        return profileId;
    }

    public int getProgramId() {
        return programId;
    }


    @Override
    public String toString() {
        if (Id == 0) return "";
        ProgramManager programManager = new ProgramManager();
        String title = programManager.getProgramById(getProgramId()).getTitle();
        MovieManager movieManager = new MovieManager();
        Movie m = movieManager.getMovieByProgramId(getProgramId());

        if (m != null) {
            return title + " Watched for " + getPercentage() + "%";
        }else{
            EpisodeManager episodeManager = new EpisodeManager();
            Episode e = episodeManager.getEpisodeByProgramId(getProgramId());
            return title + " se" + e.getSeasonNr() + "e" + e.getEpisodeNr() + " Watched for " + getPercentage() + "%";
        }
    }
}

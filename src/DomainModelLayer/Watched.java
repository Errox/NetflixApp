package DomainModelLayer;

import ApplicationLayer.EpisodeManager;
import ApplicationLayer.MovieManager;
import ApplicationLayer.ProgramManager;

import java.util.Objects;

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
            if(e != null){
                return title + " se" + e.getSeasonNr() + "e" + e.getEpisodeNr() + " Watched for " + getPercentage() + "%";
            }
            else{
                return title;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Watched watched = (Watched) o;
        return
                profileId == watched.profileId &&
                programId == watched.programId &&
                percentage == watched.percentage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, profileId, programId, percentage);
    }
}

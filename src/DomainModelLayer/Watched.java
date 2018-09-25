package DomainModelLayer;

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

}

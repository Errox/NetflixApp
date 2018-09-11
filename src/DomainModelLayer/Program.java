package DomainModelLayer;

public class Program {

    private int programId;
    private String title;
    private int timeSpan;

    public Program(int programId, String title, int timeSpan){
        this.programId = programId;
        this.title = title;
        this.timeSpan = timeSpan;
    }

    public int getProgramId() {
        return programId;
    }

    public String getTitle() {
        return title;
    }

    public int getTimeSpan() {
        return timeSpan;
    }
}

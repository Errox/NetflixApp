package DomainModelLayer;

import java.util.Date;

public class Program {

    private int Id;
    private String title;
    private Date timeSpan;

    public Program(int Id, String title, Date timeSpan){
        this.Id = Id;
        this.title = title;
        this.timeSpan = timeSpan;
    }

    public int getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public Date getTimeSpan() {
        return timeSpan;
    }
}

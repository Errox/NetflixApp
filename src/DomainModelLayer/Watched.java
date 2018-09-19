package DomainModelLayer;

public class Watched {

    private int Id;
    private String name;
    private int seen;
    private int percentage;

    public Watched(int Id, String name, int seen, int percentage) {
        this.Id = Id;
        this.name = name;
        this.seen = seen;
        this.percentage = percentage;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getSeen() {
        return seen;
    }

    public int getPercentage() {
        return percentage;
    }
}

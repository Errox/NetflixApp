package DomainModelLayer;

public class Watched {

    private int subscriptionNumber;
    private String name;
    private int seen;
    private int percentage;

    public Watched(int subscriptionNumber, String name, int seen, int percentage) {
        this.subscriptionNumber = subscriptionNumber;
        this.name = name;
        this.seen = seen;
        this.percentage = percentage;
    }

    public int getSubscriptionNumber() {
        return subscriptionNumber;
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

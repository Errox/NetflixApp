package DomainModelLayer;

public class Account {

    private int subscriptionNumber;
    private String name;
    private String streetName;
    private String postalCode;
    private String houseNumber;
    private String place;

    public Account(int subscriptionNumber, String name, String streetName, String postalCode, String houseNumber, String place){
        this.subscriptionNumber = subscriptionNumber;
        this.name = name;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.place = place;
    }

    public Account(String name, String streetName, String postalCode, String houseNumber, String place){
        //this.subscriptionNumber = subscriptionNumber;
        this.name = name;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.place = place;
    }

    public int getSubscriptionNumber() {
        return subscriptionNumber;
    }

    public String getName() {
        return name;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPlace() {
        return place;
    }
}

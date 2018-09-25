package DomainModelLayer;

public class Account {

    private int Id;
    private String name;
    private String streetName;
    private String postalCode;
    private String houseNumber;
    private String place;

    public Account(int Id, String name, String streetName, String postalCode, String houseNumber, String place) {
        this.Id = Id;
        this.name = name;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.place = place;
    }

    public Account(String name, String streetName, String postalCode, String houseNumber, String place) {
        this(0, name, streetName, postalCode, houseNumber, place);
    }

    public int getId() {
        return Id;
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

    @Override
    public String toString() {
        return "Account: " + getName();
    }
}

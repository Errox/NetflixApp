package DomainModelLayer;

import java.util.Date;

public class Profile {

    private int subscriptionNumber;
    private String name;
    private Date birthDate;

    public Profile(String name, Date birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getSubscriptionNumber() {
        return subscriptionNumber;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}

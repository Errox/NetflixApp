package DomainModelLayer;

import java.util.Date;

public class Profile {

    private int Id;
    private String name;
    private Date birthDate;
    private int accountId;

    public Profile(int Id, String name, Date birthDate, int accountId){
        this.Id = Id;
        this.name = name;
        this.birthDate = birthDate;
        this.accountId = accountId;
    }

    public Profile(String name, Date birthDate, int accountId){
        this(0, name, birthDate, accountId);
    }

    public int getId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}

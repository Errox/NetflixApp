package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.ProfileManager;
import DomainModelLayer.Account;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AccountPanel extends JPanel {

    public AccountPanel() {
        //5. Geef de accounts met slechts 1 profiel.
        setLayout(new GridLayout(10, 1, 10, 10));
        Label l = new Label();
        l.setText("This is a list with accounts that only have one profile.");
        add(l);
        // To build model for JList
        DefaultListModel listModel = new DefaultListModel();

        AccountManager accountManager = new AccountManager();
        ProfileManager profileManager = new ProfileManager();

        //List all accounts.
        List<Account> accountList = new ArrayList<>();
        accountList.addAll(accountManager.getAllAccounts());

        List<Account> accountsWithOneProfile = new ArrayList<>();

        for (int i = 0; i < accountList.size(); i++) {
            //As specified. List accounts with only one profile.
            if (profileManager.getProfileCount(accountList.get(i)) == 1)
                accountsWithOneProfile.add(accountList.get(i));
        }

        //Loop through and add all.
        for (int i = 0; i < accountsWithOneProfile.size(); i++) {
            listModel.addElement(accountsWithOneProfile.get(i).toString());
        }

        JList listSingularAccounts = new JList(listModel);
        add(listSingularAccounts);
    }

    //name street postalcode housenumber place

    public JPanel SeriesContainer(String Name, String Street, String PostalCode, int HouseNumber, String Place ){
        JPanel p = new JPanel();

        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setSize(new Dimension(200, 200));
        p.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));

        JLabel name = new JLabel("Name : " + Name);
        JLabel street = new JLabel("Street : " + Street);
        JLabel postalcode = new JLabel("PostalCode : " + PostalCode);
        JLabel housenumber = new JLabel("HouseNumber : " + HouseNumber);
        JLabel place = new JLabel("Place : " + Place);

        p.add(name);
        p.add(street);
        p.add(postalcode);
        p.add(housenumber);
        p.add(place);

        return p;
    }
}

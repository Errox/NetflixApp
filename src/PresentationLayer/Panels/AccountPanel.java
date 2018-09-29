package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.ProfileManager;
import DomainModelLayer.Account;
import DomainModelLayer.Profile;

import javax.swing.*;
import java.awt.color.ProfileDataException;
import java.util.ArrayList;
import java.util.List;

public class AccountPanel extends JPanel {

    private AccountManager accountManager = new AccountManager();

    //Done, Fine tune code. remove the double list, and priv variable.

    public AccountPanel() {
        DefaultListModel listModel = new DefaultListModel();

        ProfileManager profileManager = new ProfileManager();

        List<Account> accountList = new ArrayList<>();
        accountList.addAll(accountManager.getAllAccounts());

        List<Account> accountsWithOneProfile = new ArrayList<>();

        for(int i = 0; i < accountList.size(); i++){
            if(profileManager.getProfileCount(accountList.get(i)) == 1)
                accountsWithOneProfile.add(accountList.get(i));
        }

        for(int i = 0; i < accountsWithOneProfile.size(); i++) {
            listModel.addElement(accountsWithOneProfile.get(i).toString());
        }

        JList listSingularAccounts = new JList(listModel);

        add(listSingularAccounts);

    }
}

package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.MovieManager;
import DomainModelLayer.Account;
import PresentationLayer.EventHandlers.lForAccountMovieWatched;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountMoviePanel extends JPanel {
    //3. Welke films zijn er door een door de gebruiker geselecteerd account bekeken?

    private DefaultListModel<String> defaultListModel;
    private JComboBox account;
    private JList<String> list;

    private String labelText;
    public AccountMoviePanel() {
        setLayout(new GridLayout(10, 1, 10, 10));

        defaultListModel = new DefaultListModel<>();
        list = new JList<>( defaultListModel );
        this.list.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        AccountManager ac = new AccountManager();
        this.account = new JComboBox<>(ac.getAllAccounts().toArray());
        this.account.setModel(new DefaultComboBoxModel(ac.getAllAccounts().toArray()));
        this.account.addActionListener(new lForAccountMovieWatched(this));

        add(this.account);
        add(this.list);
        update();
    }

    public void update(){
        if (defaultListModel != null)
            defaultListModel.clear();

        Account ac = (Account) this.account.getSelectedItem();
        int accountId = ac.getId();

        MovieManager mm = new MovieManager();
        Map<String, String> Movies = mm.getMoviesByAccountId(accountId);

        for(Map.Entry<String, String> entry : Movies.entrySet()) {
            labelText = "User " + entry.getKey() + " watched movie : " + entry.getValue() ;
            defaultListModel.addElement(labelText);
        }

    }
}

package PresentationLayer.Panels;

import ApplicationLayer.*;
import DomainModelLayer.Account;
import DomainModelLayer.Episode;
import DomainModelLayer.Serie;
import PresentationLayer.EventHandlers.lForSelectingSerie;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AccountSeriesPanel extends JPanel {

    //In dit panel word een account geselecteerd en serie per aflevering het gemiddeld bekeken % van de tijdsduur weergegeven

    private DefaultListModel defaultListModel;
    private JComboBox accountCombobox;
    private JComboBox serieComboBox;
    //Sjoerd

    public AccountSeriesPanel() {
        setLayout(new FlowLayout());

        //Get all accounts
        defaultListModel =  new DefaultListModel();

        AccountManager accountManager = new AccountManager();
        accountCombobox = new JComboBox<>(accountManager.getAllAccounts().toArray());

        accountCombobox.addActionListener(new lForSelectingSerie(this));
        add(accountCombobox);


        JList list = new JList(defaultListModel);

        //Get all series
        SerieManager serieManager = new SerieManager();
        serieComboBox = new JComboBox<>(serieManager.getAllSeries().toArray());
        serieComboBox.addActionListener(new lForSelectingSerie(this));

        add(serieComboBox);
        add(list);

        update();

        //Get all episodes

    }

    public void update(){
        EpisodeManager episodeManager = new EpisodeManager();

        if(defaultListModel != null)
            defaultListModel.clear();

        List<Episode> episodes;
        episodes = episodeManager.getAllEpisodes();

        WatchedManager watchedManager = new WatchedManager();
        List<Integer> watchedTimeForEpisodesBySerie = watchedManager.getWatchedTimeForEpisodesBySerie((Account)accountCombobox.getSelectedItem(),  (Serie)serieComboBox.getSelectedItem());

        //Assuming the list size is always the same and id is always filled
        for (int i = 0; i < episodes.size(); i++) {
            defaultListModel.addElement(episodes.get(i));
        }

        for(int i = 0; i < watchedTimeForEpisodesBySerie.size(); i++){
            if(watchedTimeForEpisodesBySerie.size() > episodes.size())
                break;

            if(watchedTimeForEpisodesBySerie.get(i) == null){
                defaultListModel.set(i, defaultListModel.getElementAt(i) + " Hasn't watched yet" );
            }
            defaultListModel.set(i, defaultListModel.getElementAt(i) + ", Percentage completed: " +  watchedTimeForEpisodesBySerie.get(i));
        }
    }
}

package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.EpisodeManager;
import ApplicationLayer.ProfileManager;
import ApplicationLayer.SerieManager;
import DomainModelLayer.Account;
import DomainModelLayer.Episode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AccountSeriesPanel extends JPanel {

    //In dit panel word een account geselecteerd en serie per aflevering het gemiddeld bekeken % van de tijdsduur weergegeven

    //Sjoerd

    public AccountSeriesPanel() {

        //Get all accounts
        AccountManager accountManager = new AccountManager();
        add(new JComboBox<>(accountManager.getAllAccounts().toArray()));

        //Get all series
        SerieManager serieManager = new SerieManager();
        add(new JComboBox<>(serieManager.getAllSeries().toArray()));

        DefaultListModel defaultListModel = new DefaultListModel();
        EpisodeManager episodeManager = new EpisodeManager();

        //Get all episodes
        List<Episode> episodes;
        episodes = episodeManager.getAllEpisodes();

        for (int i = 0; i < episodes.size(); i++) {
            defaultListModel.addElement(episodes.get(i));
        }


        JList list = new JList(defaultListModel);
        add(list);


        JList list1 = new JList(defaultListModel);
        add(list1);
    }
}

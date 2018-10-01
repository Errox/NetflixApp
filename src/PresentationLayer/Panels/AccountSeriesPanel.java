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

        AccountManager accountManager = new AccountManager();
        add(new JComboBox<>(accountManager.getAllAccounts().toArray()));

        ProfileManager profileManager = new ProfileManager();
        add(new JComboBox<>(profileManager.getAllProfiles().toArray()));

        SerieManager serieManager = new SerieManager();
        add(new JComboBox<>(serieManager.getAllSeries().toArray()));

        DefaultListModel defaultListModel = new DefaultListModel();
        EpisodeManager episodeManager = new EpisodeManager();

        List<Episode> episodes;
        episodes = episodeManager.getAllEpisodes();

        for (int i = 0; i < episodes.size(); i++) {
            defaultListModel.addElement(episodes.get(i));
        }

        JList list = new JList(defaultListModel);

        add(list);
    }
}

package PresentationLayer.Panels;

import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Controls.ManageType;
import PresentationLayer.EventHandlers.SyncManager;
import PresentationLayer.EventHandlers.lForTabChanged;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;

public class MainPanel extends JPanel {

    private JTabbedPane tabPane;
    private SyncManager[] syncable;

    public MainPanel() {
        tabPane = new JTabbedPane();
        SetVisualDetails();

        //store ref in array to pass to the Action listener.
        JPanel[] panels  = new JPanel[]{new ManageAccount(), new ManageProfile(),
                                        new ManageWatched(), new SeriesWatchedPanel(),
                                        new AccountSeriesPanel(), new AccountMoviePanel(),
                                        new MoviePanel(), new AccountPanel(),
                                        new MovieWatchedPanel()};

        //create an array of objects that implement SyncManager;
        syncable = new SyncManager[panels.length];
        //method that boxes object to syncable
        setSyncable(panels);
        //After boxing, hookup the event.
        tabPane.addChangeListener(new lForTabChanged(syncable));


        tabPane.addTab(ControlNames.TAB_ACCCOUNT, panels[0]);
        tabPane.addTab(ControlNames.TAB_PROFILES, panels[1]);
        tabPane.addTab(ControlNames.TAB_WATCHED,  panels[2]);
        tabPane.addTab(ControlNames.TAB_SERIES_INFO, panels[3]);
        tabPane.addTab(ControlNames.TAB_PROFILE_SERIE_INFO, panels[4]);
        tabPane.addTab(ControlNames.TAB_ACCOUNT_MOVIE_INFO, panels[5]);
        tabPane.addTab(ControlNames.TAB_MOVIE_INFO, panels[6]);
        tabPane.addTab(ControlNames.TAB_ACCOUNT_INFO, panels[7]);
        tabPane.addTab(ControlNames.TAB_MOVIE_WATCHED_INFO, panels[8]);

        tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        add(tabPane);

        add(new InfoPanel(), BorderLayout.SOUTH);
    }

    private void setSyncable(JPanel[] panelCollection) {

        for(int i = 0; i < panelCollection.length; i++){
            syncable[i] = (SyncManager)panelCollection[i];
        }
    }

    private void SetVisualDetails() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1280, 720));
    }
}

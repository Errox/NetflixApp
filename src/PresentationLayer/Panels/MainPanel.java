package PresentationLayer.Panels;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {


    private JTabbedPane tabPane;

    public MainPanel(){
        tabPane = new JTabbedPane();
        SetVisualDetails();

        tabPane.addTab("Accounts", new ManagePanel(ManagePanel.ManageType.ACCOUNT));
        tabPane.addTab("Profiles", new ManagePanel(ManagePanel.ManageType.PROFILE));
        tabPane.addTab("Watched", new ManagePanel(ManagePanel.ManageType.EDIT));

        tabPane.addTab("Serie(s) information", new SeriesPanel());
        tabPane.addTab("Profile series information", new AccountSeriesPanel());
        tabPane.addTab("Account movie information", new AccountMoviePanel());
        tabPane.addTab("Movie information", new MoviePanel());
        tabPane.addTab("Account information", new AccountPanel());
        tabPane.addTab("Movie watcher(s) information", new MovieWatchersPanel());

        tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        add(tabPane);

        add(new InfoPanel(), BorderLayout.SOUTH);
    }

    private void SetVisualDetails(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1280, 720));
    }
}

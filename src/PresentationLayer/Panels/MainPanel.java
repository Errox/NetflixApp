package PresentationLayer.Panels;

import PresentationLayer.Controls.ManageType;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private JTabbedPane tabPane;

    public MainPanel(){
        tabPane = new JTabbedPane();
        SetVisualDetails();

        tabPane.addTab("Accounts", new ManagePanel(ManageType.ACCOUNT));
        tabPane.addTab("Profiles", new ManagePanel(ManageType.PROFILE));
        tabPane.addTab("Watched", new ManagePanel(ManageType.WATCHED));

        tabPane.addTab("Serie information", new SeriesPanel());
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

package PresentationLayer.Panels;

import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Controls.ManageType;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private JTabbedPane tabPane;

    public MainPanel() {
        tabPane = new JTabbedPane();
        SetVisualDetails();

        tabPane.addTab(ControlNames.TAB_ACCCOUNT, new ManagePanel(ManageType.ACCOUNT));
        tabPane.addTab(ControlNames.TAB_PROFILES, new ManagePanel(ManageType.PROFILE));
        tabPane.addTab(ControlNames.TAB_WATCHED, new ManagePanel(ManageType.WATCHED));
        tabPane.addTab(ControlNames.TAB_SERIES_INFO, new SeriesWatchedPanel());
        tabPane.addTab(ControlNames.TAB_PROFILE_SERIE_INFO, new AccountSeriesPanel());
        tabPane.addTab(ControlNames.TAB_ACCOUNT_MOVIE_INFO, new AccountMoviePanel());
        tabPane.addTab(ControlNames.TAB_MOVIE_INFO, new MoviePanel());
        tabPane.addTab(ControlNames.TAB_ACCOUNT_INFO, new AccountPanel());
        tabPane.addTab(ControlNames.TAB_MOVIE_WATCHED_INFO, new MovieWatchedPanel());

        tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        add(tabPane);

        add(new InfoPanel(), BorderLayout.SOUTH);
    }

    private void SetVisualDetails() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1280, 720));
    }
}

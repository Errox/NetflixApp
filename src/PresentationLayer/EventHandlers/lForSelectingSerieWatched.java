package PresentationLayer.EventHandlers;


import PresentationLayer.Panels.SeriesWatchedPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForSelectingSerieWatched implements ActionListener {

    private SeriesWatchedPanel seriesWatchedPanel;

    public lForSelectingSerieWatched(SeriesWatchedPanel seriesWatchedPanel) {
        this.seriesWatchedPanel = seriesWatchedPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        seriesWatchedPanel.update();
    }
}

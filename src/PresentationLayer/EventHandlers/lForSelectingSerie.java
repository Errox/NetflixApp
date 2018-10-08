package PresentationLayer.EventHandlers;


import PresentationLayer.Panels.AccountSeriesPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForSelectingSerie implements ActionListener {

    private AccountSeriesPanel accountSeriesPanel;

    public lForSelectingSerie(AccountSeriesPanel accountSeriesPanel) {
        this.accountSeriesPanel = accountSeriesPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        accountSeriesPanel.update();
    }
}

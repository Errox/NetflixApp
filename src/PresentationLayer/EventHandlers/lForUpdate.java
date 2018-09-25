package PresentationLayer.EventHandlers;

import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Controls.ManageType;
import PresentationLayer.Panels.ManagePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForUpdate implements ActionListener {

    private ManagePanel managePanel;

    public lForUpdate(ManagePanel managePanel) {
        this.managePanel = managePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button.getName().equals(ControlNames.MANAGE_BUTTON_UPDATE)) {
            if (managePanel.getManageType() == ManageType.ACCOUNT) {
                managePanel.ManageAccount(true);
            } else if (managePanel.getManageType() == ManageType.PROFILE) {
                managePanel.ManageProfile(true);
            } else if (managePanel.getManageType() == ManageType.WATCHED) {
                managePanel.ManageWatched();
            }
        }
    }
}

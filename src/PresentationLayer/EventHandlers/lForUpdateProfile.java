package PresentationLayer.EventHandlers;

import PresentationLayer.Panels.ManageProfile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForUpdateProfile implements ActionListener {
    private ManageProfile manageProfile;

    public lForUpdateProfile(ManageProfile manageProfile) {
        this.manageProfile = manageProfile;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        manageProfile.manageProfile(true);
    }
}

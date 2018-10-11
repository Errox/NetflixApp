package PresentationLayer.EventHandlers;

import PresentationLayer.Panels.ManageProfile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForDeleteProfile implements ActionListener {

    private ManageProfile manageProfile;

    public lForDeleteProfile(ManageProfile manageProfile) {
        this.manageProfile = manageProfile;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        manageProfile.handleDelete();
    }
}

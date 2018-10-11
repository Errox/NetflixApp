package PresentationLayer.EventHandlers;

import PresentationLayer.Panels.ManageAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForUpdateAccount implements ActionListener {

    private ManageAccount manageAccount;

    public lForUpdateAccount(ManageAccount manageAccount) {
        this.manageAccount = manageAccount;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        manageAccount.manageAccount(true);
    }
}

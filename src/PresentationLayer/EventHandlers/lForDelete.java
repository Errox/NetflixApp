package PresentationLayer.EventHandlers;

import ApplicationLayer.AccountManager;
import ApplicationLayer.ProfileManager;
import ApplicationLayer.WatchedManager;
import DomainModelLayer.Account;
import DomainModelLayer.Profile;
import DomainModelLayer.Watched;
import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Controls.ManageType;
import PresentationLayer.Panels.ManagePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static PresentationLayer.Controls.ControlNames.CONFIRM_REMOVE;
import static PresentationLayer.Controls.ControlNames.CONFIRM_TITLE_WARNING;

public class lForDelete implements ActionListener {

    private ManagePanel managePanel;

    public lForDelete(ManagePanel managePanel) {
        this.managePanel = managePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button.getName().equals(ControlNames.MANAGE_BUTTON_DELETE)) {
            int dialogResult = JOptionPane.showConfirmDialog(null, CONFIRM_REMOVE, CONFIRM_TITLE_WARNING, JOptionPane.YES_NO_OPTION);

            if (managePanel.getManageType() == ManageType.ACCOUNT) {
                if (dialogResult == JOptionPane.YES_OPTION) {
                    Account w = (Account) managePanel.getSelectedObject();
                    System.out.println(w.getId());

                    AccountManager accountManager = new AccountManager();
                    accountManager.deleteAccounts(w);
                    managePanel.updateCombobox();
                }
            } else if (managePanel.getManageType() == ManageType.PROFILE) {
                if (dialogResult == JOptionPane.YES_OPTION) {

                    Profile w = (Profile) managePanel.getSelectedObject();
                    System.out.println(w.getId());

                    ProfileManager profileManager = new ProfileManager();

                    profileManager.deleteProfile(w);
                    managePanel.updateCombobox();
                }
            } else if (managePanel.getManageType() == ManageType.WATCHED) {
                if (dialogResult == JOptionPane.YES_OPTION) {
                    Watched w = (Watched) managePanel.getSelectedObject();
                    System.out.println(w.getId());

                    WatchedManager watchedManager = new WatchedManager();
                    watchedManager.deleteWatched(w);
                    managePanel.updateCombobox();
                }
            }
        }
    }
}

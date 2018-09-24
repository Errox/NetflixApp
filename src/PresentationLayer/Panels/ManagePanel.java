package PresentationLayer.Panels;

import ApplicationLayer.AccountManager;
import ApplicationLayer.ProfileManager;
import ApplicationLayer.WatchedManager;
import DomainModelLayer.ManageType;
import PresentationLayer.Controls.ControlNames;
import PresentationLayer.EventHandlers.lForButtons;

import javax.swing.*;
import java.awt.*;

public class ManagePanel extends JPanel {

    private ManageType manageType;
    private JComboBox accounts, profiles, watched;

    public ManagePanel(ManageType manageType){
        this.manageType = manageType;

        //JPanel related.
        setLayout(new BorderLayout());

        add(createButtonPanel(), BorderLayout.SOUTH);
        add(createContentPanel(), BorderLayout.NORTH);
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        JLabel manageLabel = new JLabel("Managing " + manageType.toString().toLowerCase());
        panel.add(manageLabel);

        JLabel underManage = new JLabel("test");
        panel.add(underManage);


        if(manageType == ManageType.ACCOUNT) {
            accounts = new JComboBox<>(new AccountManager().getAllAccounts().toArray());
            panel.add(accounts);

        }else if(manageType == ManageType.PROFILE){
             profiles = new JComboBox<>(new ProfileManager().getAllProfiles().toArray());
             panel.add(profiles);

        }else if(manageType == ManageType.WATCHED){
            watched = new JComboBox<>(new WatchedManager().getAllWatched().toArray());
            panel.add(watched);

        }


        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JButton createButton = new JButton("Create");
        createButton.setName(ControlNames.MANAGE_BUTTON_CREATE);
        panel.add(createButton);

        JButton updateButton = new JButton("Update");
        updateButton.setName(ControlNames.MANAGE_BUTTON_UPDATE);

        panel.add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setName(ControlNames.MANAGE_BUTTON_DELETE);
        panel.add(deleteButton);

        lForButtons managementButtonsEvents = new lForButtons(manageType, accounts);
        createButton.addActionListener(managementButtonsEvents);
        updateButton.addActionListener(managementButtonsEvents);
        deleteButton.addActionListener(managementButtonsEvents);

        return panel;
    }
}

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
    private JPanel updatePanel;

    public ManagePanel(ManageType manageType){
        this.manageType = manageType;

        //JPanel related.
        setLayout(new BorderLayout());

        updatePanel = createUpdatePanel();
        add(createButtonPanel(), BorderLayout.SOUTH);
        add(createContentPanel(), BorderLayout.NORTH);
        add(updatePanel, BorderLayout.CENTER);
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        JLabel manageLabel = new JLabel("Managing " + manageType.toString().toLowerCase());
        panel.add(manageLabel);

        JLabel underManage = new JLabel("test");
        panel.add(underManage);

        JComboBox comboBox = new JComboBox<>();

        if(manageType == ManageType.ACCOUNT) {
            AccountManager acm = new AccountManager();
            comboBox.setModel(new DefaultComboBoxModel(acm.getAllAccounts().toArray()));
        }else if(manageType == ManageType.PROFILE){
            ProfileManager pfm = new ProfileManager();
            comboBox.setModel(new DefaultComboBoxModel(pfm.getAllProfiles().toArray()));
        }else if(manageType == ManageType.WATCHED){
            WatchedManager wm = new WatchedManager();
            comboBox.setModel(new DefaultComboBoxModel(wm.getAllWatched().toArray()));
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

        lForButtons managementButtonsEvents =new lForButtons(panel, updatePanel);
        createButton.addActionListener(managementButtonsEvents);
        updateButton.addActionListener(managementButtonsEvents);
        deleteButton.addActionListener(managementButtonsEvents);

        return panel;
    }

    //This needs to be created neatly. Withing another form to edit.

    private JPanel createUpdatePanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.setVisible(false);
        panel.setPreferredSize(new Dimension(100, 100));
        //setDefaultStyle(panel);

        JLabel a = new JLabel("name");
        panel.add(a);


        JTextArea b = new JTextArea();
        panel.add(b);

        JLabel a1 = new JLabel("streetName");
        a1.setVerticalAlignment(0);
        panel.add(a1);

        JTextArea b1 = new JTextArea();
        panel.add(b1);

        JLabel a2 = new JLabel("postalCode");
        panel.add(a2);

        JTextArea b2 = new JTextArea();
        panel.add(b2);

        JLabel a3 = new JLabel("houseNumber");
        panel.add(a3);

        JTextArea b3 = new JTextArea();
        panel.add(b3);

        JLabel a4 = new JLabel("place");
        panel.add(a4);

        JTextArea b4 = new JTextArea();
        panel.add(b4);

        JButton saveButton = new JButton("Save");
        JButton discardButton = new JButton("Discard");

        panel.add(saveButton);
        panel.add(discardButton);
        return panel;



    }

}

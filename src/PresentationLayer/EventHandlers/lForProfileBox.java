package PresentationLayer.EventHandlers;

import ApplicationLayer.ProfileManager;
import DomainModelLayer.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForProfileBox implements ActionListener {

    private JComboBox jComboBox;
    private JComboBox jComboBoxTarget;

    public lForProfileBox(JComboBox jComboBox, JComboBox jComboBoxTarget) {
        this.jComboBox = jComboBox;
        this.jComboBoxTarget = jComboBoxTarget;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jComboBoxTarget.setModel(new DefaultComboBoxModel((new ProfileManager().getProfilesFromOwner((Account) jComboBox.getSelectedItem()).toArray())));
    }
}

package PresentationLayer.EventHandlers;

import ApplicationLayer.WatchedManager;
import DomainModelLayer.Profile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForWatchedBox implements ActionListener {

    private JComboBox jComboBox;
    private JComboBox jComboBoxTarget;

    public lForWatchedBox(JComboBox jComboBox, JComboBox jComboBoxTarget) {
        this.jComboBox = jComboBox;
        this.jComboBoxTarget = jComboBoxTarget;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jComboBox.getSelectedItem() != null)
            jComboBoxTarget.setModel(new DefaultComboBoxModel((new WatchedManager().getAllWatchedForProfile((Profile) jComboBox.getSelectedItem()).toArray())));
    }
}

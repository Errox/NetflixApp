package PresentationLayer.EventHandlers;

import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Controls.ManageType;
import PresentationLayer.ManageForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForCreate implements ActionListener {

    private ManageType manageType;

    public lForCreate(ManageType manageType){
        this.manageType = manageType;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton)e.getSource();

        if(button.getName().equals(ControlNames.MANAGE_BUTTON_CREATE)){
            new ManageForm(manageType);
        }
    }
}

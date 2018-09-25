package PresentationLayer.EventHandlers;

import PresentationLayer.Controls.ManageType;
import PresentationLayer.Controls.ControlNames;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForDelete implements ActionListener {

    private ManageType manageType;

    public lForDelete(ManageType manageType){
        this.manageType = manageType;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        if(button.getName().equals(ControlNames.MANAGE_BUTTON_DELETE)){

            int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete the selected record?", "Warning", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                // Delete code here
            }
        }
    }
}

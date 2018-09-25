package PresentationLayer.EventHandlers;

import PresentationLayer.Controls.ManageType;
import PresentationLayer.Controls.ControlNames;
import PresentationLayer.Controls.ModifyType;
import PresentationLayer.ManageForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForButtons implements ActionListener {

    private ManageType manageType;
    private JComboBox selectedItem;

    public lForButtons(ManageType manageType, JComboBox selected){
        this.manageType = manageType;
        this.selectedItem = selected;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        if(button.getName().equals(ControlNames.MANAGE_BUTTON_CREATE)){
            new ManageForm(ModifyType.CREATE, manageType);
        }
        else if(button.getName().equals(ControlNames.MANAGE_BUTTON_UPDATE)){
            new ManageForm(ModifyType.UPDATE, manageType);
        }
        else if(button.getName().equals(ControlNames.MANAGE_BUTTON_DELETE)){

            selectedItem.getSelectedItem();

            int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete the selected record?", "Warning", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                // Saving code here
            }
        }
    }
}

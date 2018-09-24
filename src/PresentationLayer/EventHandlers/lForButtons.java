package PresentationLayer.EventHandlers;

import PresentationLayer.Controls.ControlNames;
import PresentationLayer.ManageForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForButtons implements ActionListener {

    private JPanel managementPanel;
    private JPanel updatePanel;

    public lForButtons(JPanel managementPanel, JPanel updatePanel){
            this.managementPanel = managementPanel;
            this.updatePanel = updatePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        if(button.getName().equals(ControlNames.MANAGE_BUTTON_CREATE)){
            managementPanel.setVisible(false);
            updatePanel.setVisible(true);

        }
        else if(button.getName().equals(ControlNames.MANAGE_BUTTON_UPDATE)){
            //if(ManageType. == ManageType.ACCOUNT)
                //new ManageForm().ManageAccount();
        }
        else if(button.getName().equals(ControlNames.MANAGE_BUTTON_DELETE)){
            int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete the selected record?", "Warning", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                // Saving code here
            }
        }
    }
}

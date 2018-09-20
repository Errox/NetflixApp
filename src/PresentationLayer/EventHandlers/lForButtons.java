package PresentationLayer.EventHandlers;

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

        if(button.getText() == "Create"){
            managementPanel.setVisible(false);
            updatePanel.setVisible(true);
        }
        else if(button.getText() == "Update"){

        }
        else if(button.getText() == "Delete"){
            int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete the selected record?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                // Saving code here
            }
        }
    }
}

package PresentationLayer.Panels;

import PresentationLayer.Controls.ControlNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ManagePanelBase {

    public static JPanel InitializeButtonPane(ActionListener lForCreateButton, ActionListener lForUpdateButton, ActionListener lForDeleteButton ) {
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

        createButton.addActionListener(lForCreateButton);
        updateButton.addActionListener(lForUpdateButton);
        deleteButton.addActionListener(lForDeleteButton);

        return panel;
    }
}

package PresentationLayer.Panels;

import PresentationLayer.Controls.ControlNames;
import PresentationLayer.EventHandlers.SyncManager;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel implements SyncManager {

    public InfoPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1280, 25));

        JLabel title = new JLabel(ControlNames.APPLICATION_NAME);
        JLabel info = new JLabel(ControlNames.INFO_WIDGET_TEXT);

        add(title, BorderLayout.WEST);
        add(info, BorderLayout.EAST);

        title.setForeground(Color.lightGray);
        info.setForeground(Color.lightGray);
        setBackground(Color.gray.darker().darker().darker());
    }

    @Override
    public void update() {
        // Nothing to be updated.
    }
}

package PresentationLayer.EventHandlers;

import PresentationLayer.Panels.ManageWatched;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForDeleteWatched implements ActionListener {
    private ManageWatched manageWatched;

    public lForDeleteWatched(ManageWatched manageWatched) {
        this.manageWatched = manageWatched;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        manageWatched.handleDelete();
    }
}

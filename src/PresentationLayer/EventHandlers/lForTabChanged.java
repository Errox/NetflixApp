package PresentationLayer.EventHandlers;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class lForTabChanged implements ChangeListener {
    private SyncManager[] updatableCollection;
    public lForTabChanged(SyncManager[] updatableCollection){
        this.updatableCollection = updatableCollection;
    }
    @Override
    public void stateChanged(ChangeEvent e) {

        updatableCollection[((JTabbedPane)e.getSource()).getSelectedIndex()].update();

// A loop would cause the main thread to be flooded with calls to update all Panels, which isn't needed at all.
//        for (SyncManager syncable: updatableCollection) {
//            syncable.update();
//        }
    }
}

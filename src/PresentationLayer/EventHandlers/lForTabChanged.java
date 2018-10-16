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


//        for (SyncManager syncable: updatableCollection) {
//            syncable.update();
//        }
    }
}

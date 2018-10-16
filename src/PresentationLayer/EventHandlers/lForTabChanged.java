package PresentationLayer.EventHandlers;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class lForTabChanged implements ChangeListener {
    private SyncManager[] updatableCollection;
    public lForTabChanged(SyncManager[] updatableCollection){
        this.updatableCollection = updatableCollection;
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        for (SyncManager syncable: updatableCollection) {
            syncable.update();
        }
    }
}

package PresentationLayer.EventHandlers;

import PresentationLayer.Panels.AccountMoviePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lForAccountMovieWatched implements ActionListener {
    private AccountMoviePanel amp;

    public lForAccountMovieWatched(AccountMoviePanel amp) {
        this.amp = amp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        amp.update();
    }
}

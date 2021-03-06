package carcassonne.view.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import carcassonne.control.ControllerFacade;

/**
 * A simple listener for the new game button.
 * @author Timur Saglam
 */
public class NewRoundListener implements ActionListener {
    private final ControllerFacade controller;
    private final JMenuItem itemNewRound;
    private final JMenuItem itemAbortRound;

    /**
     * Creates the listener.
     * @param controller is the main controller to request actions.
     * @param itemNewRound is the menu item to start a new round.
     * @param itemAbortRound is the menu item to abort the current round.
     */
    public NewRoundListener(ControllerFacade controller, JMenuItem itemNewRound, JMenuItem itemAbortRound) {
        this.controller = controller;
        this.itemNewRound = itemNewRound;
        this.itemAbortRound = itemAbortRound;
    }

    /**
     * Calls method on main menu bar for a new game.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (itemNewRound.isEnabled()) {
            controller.requestNewRound();
            itemAbortRound.setEnabled(true);
            itemNewRound.setEnabled(false);
        }
    }
}

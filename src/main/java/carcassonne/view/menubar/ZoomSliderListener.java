/**
 * 
 */
package carcassonne.view.menubar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import carcassonne.view.main.MainGUI;

/**
 * Blockable event and mouse listener for the zoom slider. Blocking is required when the slider is internally changed.
 * This listener also smoothes the dragging by limiting the updates to certain steps.
 * @author Timur Saglam
 */
public class ZoomSliderListener extends MouseAdapter implements ChangeListener {

    private static final int SMOOTHING_FACTOR = 5; // only update zoom with this step size.
    private boolean blocked;
    private MainGUI mainUI;
    private JSlider slider;
    private int previousValue;

    /**
     * Creates the listener.
     * @param mainUI is the main user interface, needed for zooming.
     * @param slider is the slider, needed for the values.
     */
    public ZoomSliderListener(MainGUI mainUI, JSlider slider) {
        blocked = false;
        this.mainUI = mainUI;
        this.slider = slider;
        previousValue = -1;
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if (!blocked) {
            mainUI.setZoom(slider.getValue(), false);
        }
    }

    @Override
    public void stateChanged(ChangeEvent event) {
        int smoothedValue = slider.getValue() / SMOOTHING_FACTOR * SMOOTHING_FACTOR;
        if (!blocked && previousValue != smoothedValue) { // limit zoom updated when dragging.
            previousValue = smoothedValue;
            mainUI.setZoom(smoothedValue, true);
        }
    }

    /**
     * Returns whether the listener is blocked or not.
     * @return true true if the listener is not acting on events or clicks.
     */
    public boolean isBlocked() {
        return blocked;
    }

    /**
     * Blocks or unblocks the listener.
     * @param blocked should be true if the listener is not supposed to fire for events or clicks.
     */
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}

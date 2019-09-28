package engine.events;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseWheel implements MouseWheelListener {

    private int delta = 0;

    private boolean scrolled = false;

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        delta = e.getWheelRotation() * e.getScrollAmount() * 5;
        scrolled = true;
    }

    public void update() {
        scrolled = false;
    }

    public int getDelta() {
        return delta;
    }

    public boolean isScrolled() {
        return scrolled;
    }
}

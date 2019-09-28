package engine.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    private boolean pressed = false;

    private MouseMotionHandler mouseMotionHandler;

    public MouseHandler(MouseMotionHandler mouseMotionHandler) {
        this.mouseMotionHandler = mouseMotionHandler;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseMotionHandler.leave();
    }

    public boolean isPressed() {
        return pressed;
    }

}

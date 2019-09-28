package engine.events;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionHandler implements MouseMotionListener {

    private Point pos = new Point(0, 0);

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        pos = e.getPoint();
        pos.y -= 20;
    }

    public Point getPos() {
        return pos;
    }
}

package engine.events;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionHandler implements MouseMotionListener {

    private Point pos = new Point(0, 0);

    @Override
    public void mouseDragged(MouseEvent e) {
        pos = e.getPoint();
        pos.y -= 30;
        pos.x -= 10;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        pos = e.getPoint();
        pos.y -= 30;
        pos.x -= 10;
    }

    public Point getPos() {
        return pos;
    }

    public void leave() {
        pos = new Point(-10000, -10000);
    }
}

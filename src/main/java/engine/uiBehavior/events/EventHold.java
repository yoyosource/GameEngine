package engine.uiBehavior.events;

import engine.events.KeyHandler;
import engine.events.MouseHandler;
import engine.events.MouseMotionHandler;
import engine.events.MouseWheel;
import engine.ui.ElementData;
import engine.uiBehavior.Event;

import java.awt.*;

public class EventHold extends Event {

    private boolean runWhenHidden = false;
    private Point pos = new Point(0, 0);

    public EventHold() {

    }

    public EventHold(boolean runWhenHidden) {
        this.runWhenHidden = runWhenHidden;
    }

    @Override
    public boolean isEventToggle(KeyHandler keyHandler, MouseHandler mouseHandler, MouseMotionHandler mouseMotionHandler, MouseWheel mouseWheel) {
        ElementData elementData = getElement().getData();

        pos = new Point(mouseMotionHandler.getPos().x, mouseMotionHandler.getPos().y);

        if (elementData.x <= pos.x && elementData.x + elementData.width >= pos.x) {
            if (elementData.y <= pos.y && elementData.y + elementData.height >= pos.y) {
                return mouseHandler.isPressed();
            }
        }

        return false;
    }

    @Override
    public boolean runWhenHidden() {
        return runWhenHidden;
    }

    public Point getPos() {
        return pos;
    }
}

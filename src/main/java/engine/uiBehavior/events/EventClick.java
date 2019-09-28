package engine.uiBehavior.events;

import engine.events.KeyHandler;
import engine.events.MouseHandler;
import engine.events.MouseMotionHandler;
import engine.events.MouseWheel;
import engine.ui.ElementData;
import engine.uiBehavior.Event;

import java.awt.*;

public class EventClick extends Event {

    private boolean p = false;

    @Override
    public boolean isEventToggle(KeyHandler keyHandler, MouseHandler mouseHandler, MouseMotionHandler mouseMotionHandler, MouseWheel mouseWheel) {
        ElementData elementData = getElement().getData();

        Point pos = mouseMotionHandler.getPos();

        if (elementData.x < pos.x && elementData.x + elementData.width > pos.x) {
            if (elementData.y < pos.y && elementData.y + elementData.height > pos.y) {
                if (!p && mouseHandler.isPressed()) {
                    p = true;
                    return true;
                } else if (!mouseHandler.isPressed()) {
                    p = false;
                    return false;
                } else {
                    return false;
                }
            }
        }
        p = false;

        return false;
    }
}

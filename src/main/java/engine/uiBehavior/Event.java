package engine.uiBehavior;

import engine.events.KeyHandler;
import engine.events.MouseHandler;
import engine.events.MouseMotionHandler;
import engine.events.MouseWheel;
import engine.ui.Element;

import java.util.ArrayList;
import java.util.List;

public class Event {

    private List<Action> actions = new ArrayList<>();
    private Element element;

    public void setElement(Element element) {
        this.element = element;
        for (Action action : actions) {
            action.setElement(element);
        }
    }

    public Element getElement() {
        return element;
    }

    public boolean isEventToggle(KeyHandler keyHandler, MouseHandler mouseHandler, MouseMotionHandler mouseMotionHandler, MouseWheel mouseWheel) {
        return false;
    }

    public void run() {
        for (Action action : actions) {
            action.run();
        }
    }

    public void addAction(Action action) {
        actions.add(action);
    }

}

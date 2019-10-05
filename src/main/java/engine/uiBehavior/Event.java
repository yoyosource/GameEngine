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

    public final void setElement(Element element) {
        this.element = element;
        for (Action action : actions) {
            action.setElement(element);
        }
    }

    public final Element getElement() {
        return element;
    }

    public boolean isEventToggle(KeyHandler keyHandler, MouseHandler mouseHandler, MouseMotionHandler mouseMotionHandler, MouseWheel mouseWheel) {
        return false;
    }

    public final void run() {
        for (Action action : actions) {
            action.run();
        }
    }

    public final void addAction(Action action) {
        actions.add(action);
    }

    public boolean runWhenHidden() {
        return false;
    }

}

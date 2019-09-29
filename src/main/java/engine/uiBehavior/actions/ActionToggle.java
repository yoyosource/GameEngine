package engine.uiBehavior.actions;

import engine.ui.Element;
import engine.uiBehavior.Action;

public class ActionToggle extends Action {

    private boolean b = false;
    private Action action;

    public ActionToggle(Action action) {
        setId();
        this.action = action;
    }

    @Override
    public void setElement(Element element) {
        super.setElement(element);
        action.setElement(element);
    }

    @Override
    public void run() {
        b = !b;
        if (b) {
            getElement().addAction(action);
        } else {
            getElement().removeAction(action);
        }
    }
}

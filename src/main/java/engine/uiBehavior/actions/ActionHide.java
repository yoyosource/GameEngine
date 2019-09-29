package engine.uiBehavior.actions;

import engine.uiBehavior.Action;

public class ActionHide extends Action {

    @Override
    public void run() {
        getElement().setHide(true);
    }
}

package engine.uiBehavior.actions;

import engine.uiBehavior.Action;

import java.awt.*;

public class ActionColor extends Action {

    private Color color;

    public ActionColor(Color color) {
        setId();
        this.color = color;
    }

    @Override
    public void run() {
        getElement().setnColor(color);
    }
}

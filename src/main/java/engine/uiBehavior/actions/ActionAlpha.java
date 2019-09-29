package engine.uiBehavior.actions;

import engine.uiBehavior.Action;

import java.awt.*;

public class ActionAlpha extends Action {

    private int alpha;

    public ActionAlpha(int alpha) {
        setId();
        this.alpha = alpha;
    }

    @Override
    public void run() {
        getElement().setnColor(new Color(getElement().getColor().getRed(), getElement().getColor().getGreen(), getElement().getColor().getBlue(), alpha));
    }
}

package engine.uiBehavior.actions;

import engine.uiBehavior.Action;

import java.awt.*;

public class ActionColorFade extends Action {

    private int fadeTime = 100;
    private Color color;

    public ActionColorFade(Color color) {
        setId();
        this.color = color;
    }

    public ActionColorFade(Color color, int fadeTime) {
        setId();
        this.color = color;
        this.fadeTime = fadeTime;
    }

    @Override
    public void run() {
        getElement().setnColor(color);
        getElement().setMaxFade(fadeTime);
    }
}

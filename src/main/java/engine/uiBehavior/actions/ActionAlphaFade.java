package engine.uiBehavior.actions;

import engine.uiBehavior.Action;

import java.awt.*;

public class ActionAlphaFade extends Action {

    private int fadeTime = 100;
    private int alpha;

    public ActionAlphaFade(int alpha) {
        setId();
        this.alpha = alpha;
    }

    public ActionAlphaFade(int alpha, int fadeTime) {
        setId();
        this.alpha = alpha;
        this.fadeTime = fadeTime;
    }

    @Override
    public void run() {
        getElement().setnColor(new Color(getElement().getColor().getRed(), getElement().getColor().getGreen(), getElement().getColor().getBlue(), alpha));
        getElement().setMaxFade(fadeTime);
    }
}

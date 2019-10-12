package engine.uiBehavior.modifier;

import engine.uiBehavior.Modifier;

import java.awt.*;

public class ModifierTranslate extends Modifier {

    private int x, y;

    public ModifierTranslate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void modify(Graphics2D g, double rate) {
        g.translate(x / rate, y / rate);
    }

    @Override
    public void modifyInvert(Graphics2D g, double rate) {
        g.translate((-x) / rate, (-y) / rate);
    }
}

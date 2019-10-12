package engine.uiBehavior.modifier;

import engine.uiBehavior.Modifier;

import java.awt.*;

public class ModifierTranslateCenter extends Modifier {

    @Override
    public void modify(Graphics2D g, int width, int height, double rate) {
        g.translate((width / 2) / rate, (height / 2) / rate);
    }

    @Override
    public void modifyInvert(Graphics2D g, int width, int height, double rate) {
        g.translate((width / -2) / rate, (height / -2) / rate);
    }
}

package engine.uiBehavior.modifier;

import engine.uiBehavior.Modifier;

import java.awt.*;

public class ModifierTranslateCenter extends Modifier {

    @Override
    public void modify(Graphics2D g, int width, int height) {
        g.translate((width / 2), (height / 2));
    }

    @Override
    public void modifyInvert(Graphics2D g, int width, int height) {
        g.translate((width / -2), (height / -2));
    }
}

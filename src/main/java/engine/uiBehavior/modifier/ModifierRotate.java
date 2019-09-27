package engine.uiBehavior.modifier;

import engine.uiBehavior.Modifier;

import java.awt.*;

public class ModifierRotate extends Modifier {

    private double theta;

    public ModifierRotate(double theta) {
        this.theta = theta;
    }

    @Override
    public void modify(Graphics2D g) {
        g.rotate(theta);
    }

    @Override
    public void modifyInvert(Graphics2D g) {
        g.rotate(-theta);
    }
}

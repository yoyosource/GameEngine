package engine.uiBehavior.modifier;

import engine.events.KeyHandler;
import engine.uiBehavior.Modifier;

import java.awt.*;

public class ModifierRotateDynamic extends Modifier {

    private double rate;
    private double theta = 0;

    public ModifierRotateDynamic(double rate) {
        this.rate = rate;
    }

    public ModifierRotateDynamic(double rate, double theta) {
        this.rate = rate;
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

    @Override
    public void update(KeyHandler keyHandler) {
        theta += rate;
        if (theta > Math.PI * 2) {
            theta = 0;
        }
    }

}

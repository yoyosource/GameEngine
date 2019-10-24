package engine.uiBehavior.modifier;

import engine.events.KeyHandler;
import engine.uiBehavior.Modifier;

import java.awt.*;

public class ModifierTranslateMovements extends Modifier {

    private double x = 0;
    private double y = 0;
    private double posZ = 0;

    private char forward, backward, right, left, up, down;

    private double multiplier = 1;

    public ModifierTranslateMovements(char forward, char backward, char right, char left) {
        this.forward = forward;
        this.backward = backward;
        this.right = right;
        this.left = left;
        this.up = 0;
        this.down = 0;
    }

    public ModifierTranslateMovements(char forward, char backward, char right, char left, char up, char down) {
        this.forward = forward;
        this.backward = backward;
        this.right = right;
        this.left = left;
        this.up = up;
        this.down = down;
    }

    public ModifierTranslateMovements(char forward, char backward, char right, char left, double multiplier) {
        this.forward = forward;
        this.backward = backward;
        this.right = right;
        this.left = left;
        this.up = 0;
        this.down = 0;

        this.multiplier = multiplier;
    }

    public ModifierTranslateMovements(char forward, char backward, char right, char left, char up, char down, double multiplier) {
        this.forward = forward;
        this.backward = backward;
        this.right = right;
        this.left = left;
        this.up = up;
        this.down = down;

        this.multiplier = multiplier;
    }

    @Override
    public void modify(Graphics2D g) {
        g.translate(x, y);
    }

    @Override
    public void modifyInvert(Graphics2D g) {
        g.translate((-x), (-y));
    }

    @Override
    public void update(KeyHandler keyHandler) {
        if (up > 0) {
            if (keyHandler.isKeyDown(up)) {
                y -= 1 * multiplier;
            }
            if (keyHandler.isKeyDown(down)) {
                y += 1 * multiplier;
            }

            if (keyHandler.isKeyDown(right)) {
                x += 1 * multiplier;
            }
            if (keyHandler.isKeyDown(left)) {
                x -= 1 * multiplier;
            }

            if (keyHandler.isKeyDown(forward)) {
                posZ -= 0.001 * multiplier;
            }
            if (keyHandler.isKeyDown(backward)) {
                posZ += 0.001 * multiplier;
            }
        } else {
            if (keyHandler.isKeyDown(forward)) {
                y -= 1 * multiplier;
            }
            if (keyHandler.isKeyDown(backward)) {
                y += 1 * multiplier;
            }

            if (keyHandler.isKeyDown(right)) {
                x += 1 * multiplier;
            }
            if (keyHandler.isKeyDown(left)) {
                x -= 1 * multiplier;
            }
        }
    }

    public double getPosZ() {
        return posZ;
    }

}

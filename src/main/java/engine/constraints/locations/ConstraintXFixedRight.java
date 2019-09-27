package engine.constraints.locations;

import engine.constraints.constraintInterfaces.XConstraint;

public class ConstraintXFixedRight extends XConstraint {

    private int x;

    public ConstraintXFixedRight(int x) {
        this.x = x;
    }

    @Override
    public int positionX(int width, int height, int elementWidth, int elementHeight) {
        return width - elementWidth - x;
    }
}

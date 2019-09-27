package engine.constraints.locations;

import engine.constraints.constraintInterfaces.YConstraint;

public class ConstraintYFixed extends YConstraint {

    private int y;

    public ConstraintYFixed(int y) {
        this.y = y;
    }

    @Override
    public int positionY(int width, int height, int elementWidth, int elementHeight) {
        return y;
    }
}

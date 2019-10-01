package engine.constraints.locations;

import engine.constraints.constraintInterfaces.YConstraint;

public class ConstraintYFixedBottom extends YConstraint {

    private int y;

    public ConstraintYFixedBottom(int y) {
        this.y = y;
    }

    @Override
    public int positionY(int width, int height, int elementWidth, int elementHeight) {
        return height - elementHeight - y;
    }
}

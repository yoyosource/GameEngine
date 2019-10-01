package engine.constraints.locations;

import engine.constraints.constraintInterfaces.YConstraint;

public class ConstraintYFixedBottum extends YConstraint {

    private int y;

    public ConstraintYFixedBottum(int y) {
        this.y = y;
    }

    @Override
    public int positionY(int width, int height, int elementWidth, int elementHeight) {
        return height - elementHeight - y;
    }
}

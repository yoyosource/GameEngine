package engine.constraints.locations;

import engine.constraints.constraintInterfaces.YConstraint;

public class ConstraintYCenter extends YConstraint {

    @Override
    public int positionY(int width, int height, int elementWidth, int elementHeight) {
        return height / 2 - elementHeight / 2;
    }
}

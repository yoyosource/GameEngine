package engine.constraints.locations;

import engine.constraints.constraintInterfaces.YConstraint;

public class ConstraintYHeightCenter extends YConstraint {

    @Override
    public int positionY(int width, int height, int elementWidth, int elementHeight) {
        return 0 - elementHeight / 2;
    }
}

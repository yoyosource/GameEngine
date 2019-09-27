package engine.constraints.locations;

import engine.constraints.constraintInterfaces.XConstraint;

public class ConstraintXWidthCenter extends XConstraint {

    @Override
    public int positionX(int width, int height, int elementWidth, int elementHeight) {
        return 0 - elementWidth / 2;
    }
}

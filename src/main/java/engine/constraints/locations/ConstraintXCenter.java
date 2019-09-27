package engine.constraints.locations;

import engine.constraints.constraintInterfaces.XConstraint;

public class ConstraintXCenter extends XConstraint {

    @Override
    public int positionX(int width, int height, int elementWidth, int elementHeight) {
        return width / 2 - elementWidth / 2;
    }
}

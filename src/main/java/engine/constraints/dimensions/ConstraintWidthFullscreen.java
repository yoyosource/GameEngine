package engine.constraints.dimensions;

import engine.constraints.constraintInterfaces.WidthConstraint;

public class ConstraintWidthFullscreen extends WidthConstraint {

    @Override
    public int width(int width, int height, int elementHeight) {
        return width;
    }
}

package engine.constraints.dimensions;

import engine.constraints.constraintInterfaces.WidthConstraint;

public class ConstraintWidthFixed extends WidthConstraint {

    private int width = 0;

    public ConstraintWidthFixed(int width) {
        this.width = width;
    }

    @Override
    public int width(int width, int height, int elementHeight) {
        return this.width;
    }
}

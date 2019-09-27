package engine.constraints.dimensions;

import engine.constraints.constraintInterfaces.WidthConstraint;

public class ConstraintWidthPercent extends WidthConstraint {

    private double d;

    public ConstraintWidthPercent(double d) {
        this.d = d;
    }

    @Override
    public int width(int width, int height, int elementHeight) {
        return (int)(width * d);
    }
}

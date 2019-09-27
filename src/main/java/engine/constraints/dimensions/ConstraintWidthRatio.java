package engine.constraints.dimensions;

import engine.constraints.constraintInterfaces.WidthConstraint;

public class ConstraintWidthRatio extends WidthConstraint {

    private double d;

    public ConstraintWidthRatio(double d) {
        this.d = d;
    }

    @Override
    public boolean isRatio() {
        return true;
    }

    @Override
    public int width(int width, int height, int elementHeight) {
        return (int)(elementHeight * d);
    }
}

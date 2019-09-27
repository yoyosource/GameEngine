package engine.constraints.dimensions;

import engine.constraints.constraintInterfaces.WidthConstraint;

public class ConstraintWidthRatioToHeight extends WidthConstraint {

    private double d;

    public ConstraintWidthRatioToHeight(double d) {
        this.d = d;
    }

    @Override
    public int width(int width, int height, int elementHeight) {
        return (int)(height * d);
    }
}

package engine.constraints.dimensions;

import engine.constraints.constraintInterfaces.HeightConstraint;

public class ConstraintHeightPercent extends HeightConstraint {

    private double d;

    public ConstraintHeightPercent(double d) {
        this.d = d;
    }

    @Override
    public int height(int width, int height, int elementWidth) {
        return (int)(height * d);
    }
}

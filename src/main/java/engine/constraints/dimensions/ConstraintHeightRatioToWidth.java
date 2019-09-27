package engine.constraints.dimensions;

import engine.constraints.constraintInterfaces.HeightConstraint;

public class ConstraintHeightRatioToWidth extends HeightConstraint {

    private double d;

    public ConstraintHeightRatioToWidth(double d) {
        this.d = d;
    }

    @Override
    public int height(int width, int height, int elementWidth) {
        return (int)(width * d);
    }
}

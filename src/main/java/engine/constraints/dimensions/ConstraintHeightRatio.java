package engine.constraints.dimensions;

import engine.constraints.constraintInterfaces.HeightConstraint;

public class ConstraintHeightRatio extends HeightConstraint {

    private double d;

    public ConstraintHeightRatio(double d) {
        this.d = d;
    }

    @Override
    public boolean isRatio() {
        return true;
    }

    @Override
    public int height(int width, int height, int elementWidth) {
        return (int)(elementWidth * d);
    }
}

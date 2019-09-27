package engine.constraints.dimensions;

import engine.constraints.constraintInterfaces.HeightConstraint;

public class ConstraintHeightFixed extends HeightConstraint {

    private int height = 0;

    public ConstraintHeightFixed(int height) {
        this.height = height;
    }

    @Override
    public int height(int width, int height, int elementWidth) {
        return this.height;
    }
}

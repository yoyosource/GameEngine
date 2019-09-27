package engine.constraints.dimensions;

import engine.constraints.constraintInterfaces.HeightConstraint;

public class ConstraintHeightFullscreen extends HeightConstraint {

    @Override
    public int height(int width, int height, int elementWidth) {
        return height;
    }
}

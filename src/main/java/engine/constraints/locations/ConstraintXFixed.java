package engine.constraints.locations;

import engine.constraints.constraintInterfaces.XConstraint;

public class ConstraintXFixed extends XConstraint {

    private int x;

    public ConstraintXFixed(int x) {
        this.x = x;
    }

    @Override
    public int positionX(int width, int height, int elementWidth, int elementHeight) {
        return x;
    }
}

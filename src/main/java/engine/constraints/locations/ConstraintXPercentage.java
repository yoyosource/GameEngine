package engine.constraints.locations;

import engine.constraints.constraintInterfaces.XConstraint;

public class ConstraintXPercentage extends XConstraint {

    private double d;

    public ConstraintXPercentage(double d) {
        this.d = d;
    }

    @Override
    public int positionX(int width, int height, int elementWidth, int elementHeight) {
        return (int)(width * d);
    }
}

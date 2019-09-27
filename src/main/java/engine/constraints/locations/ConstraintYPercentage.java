package engine.constraints.locations;

import engine.constraints.constraintInterfaces.YConstraint;

public class ConstraintYPercentage extends YConstraint {

    private double d;

    public ConstraintYPercentage(double d) {
        this.d = d;
    }

    @Override
    public int positionY(int width, int height, int elementWidth, int elementHeight) {
        return (int)(height * d);
    }
}

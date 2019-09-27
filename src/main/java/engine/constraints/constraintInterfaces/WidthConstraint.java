package engine.constraints.constraintInterfaces;

public class WidthConstraint {

    public boolean isRatio() {
        return false;
    }

    public int width(int width, int height, int elementHeight) {
        return -1;
    }

}

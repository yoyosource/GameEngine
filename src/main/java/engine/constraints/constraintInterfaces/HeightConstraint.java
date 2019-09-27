package engine.constraints.constraintInterfaces;

public class HeightConstraint {

    public boolean isRatio() {
        return false;
    }

    public int height(int width, int height, int elementWidth) {
        return -1;
    }

}

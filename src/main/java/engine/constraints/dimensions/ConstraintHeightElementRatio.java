package engine.constraints.dimensions;

import engine.constraints.constraintInterfaces.HeightConstraint;
import engine.ui.Element;

public class ConstraintHeightElementRatio extends HeightConstraint {

    private Element element;

    private double ratio = 1;

    public ConstraintHeightElementRatio(Element element) {
        this.element = element;
    }

    public ConstraintHeightElementRatio(Element element, double ratio) {
        this.element = element;
        this.ratio = ratio;
    }

    @Override
    public int height(int width, int height, int elementWidth) {
        return (int)(element.getData().height * ratio);
    }
}

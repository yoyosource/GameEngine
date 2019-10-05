package engine.constraints.dimensions;

import engine.constraints.constraintInterfaces.WidthConstraint;
import engine.ui.Element;

public class ConstraintWidthElementRatio extends WidthConstraint {

    private Element element;

    private double ratio = 1;

    public ConstraintWidthElementRatio(Element element) {
        this.element = element;
    }

    public ConstraintWidthElementRatio(Element element, double ratio) {
        this.element = element;
        this.ratio = ratio;
    }

    @Override
    public int width(int width, int height, int elementHeight) {
        return (int)(element.getData().width * ratio);
    }
}

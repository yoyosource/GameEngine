package engine.constraints.locations;

import engine.constraints.constraintInterfaces.YConstraint;
import engine.ui.Element;

public class ConstraintYOffsetBottum extends YConstraint {

    private Element element;

    private int offset = 10;

    public ConstraintYOffsetBottum(Element element) {
        this.element = element;
    }

    public ConstraintYOffsetBottum(Element element, int offset) {
        this.element = element;
        this.offset = offset;
    }

    @Override
    public int positionY(int width, int height, int elementWidth, int elementHeight) {
        return element.getData().y - elementHeight - offset;
    }
}

package engine.constraints.locations;

import engine.constraints.constraintInterfaces.YConstraint;
import engine.ui.Element;

public class ConstraintYOffsetBottom extends YConstraint {

    private Element element;

    private int offset = 10;

    public ConstraintYOffsetBottom(Element element) {
        this.element = element;
    }

    public ConstraintYOffsetBottom(Element element, int offset) {
        this.element = element;
        this.offset = offset;
    }

    @Override
    public int positionY(int width, int height, int elementWidth, int elementHeight) {
        return element.getData().y - elementHeight - offset;
    }
}

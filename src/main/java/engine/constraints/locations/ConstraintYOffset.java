package engine.constraints.locations;

import engine.constraints.constraintInterfaces.YConstraint;
import engine.ui.Element;

public class ConstraintYOffset extends YConstraint {

    private Element element;

    private int offset = 10;

    public ConstraintYOffset(Element element) {
        this.element = element;
    }

    public ConstraintYOffset(Element element, int offset) {
        this.element = element;
        this.offset = offset;
    }

    @Override
    public int positionY(int width, int height, int elementWidth, int elementHeight) {
        return element.getData().y + element.getData().height + offset;
    }
}

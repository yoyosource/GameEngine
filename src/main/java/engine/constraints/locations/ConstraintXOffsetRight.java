package engine.constraints.locations;

import engine.constraints.constraintInterfaces.XConstraint;
import engine.ui.Element;

public class ConstraintXOffsetRight extends XConstraint {

    private Element element;

    private int offset = 10;

    public ConstraintXOffsetRight(Element element) {
        this.element = element;
    }

    public ConstraintXOffsetRight(Element element, int offset) {
        this.element = element;
        this.offset = offset;
    }

    @Override
    public int positionX(int width, int height, int elementWidth, int elementHeight) {
        return element.getData().x - elementWidth - element.getData().width - offset;
    }
}

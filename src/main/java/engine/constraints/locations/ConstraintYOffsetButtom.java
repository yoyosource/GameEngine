package engine.constraints.locations;

import engine.constraints.constraintInterfaces.YConstraint;
import engine.ui.Element;

public class ConstraintYOffsetButtom extends YConstraint {

    private Element element;

    private int offset = 10;

    public ConstraintYOffsetButtom(Element element) {
        this.element = element;
    }

    public ConstraintYOffsetButtom(Element element, int offset) {
        this.element = element;
        this.offset = offset;
    }

    @Override
    public int positionY(int width, int height, int elementWidth, int elementHeight) {
        return element.getData().y - elementHeight - element.getData().height - offset;
    }
}

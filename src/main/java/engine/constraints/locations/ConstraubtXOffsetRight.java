package engine.constraints.locations;

import engine.constraints.constraintInterfaces.XConstraint;
import engine.ui.Element;

public class ConstraubtXOffsetRight extends XConstraint {

    private Element element;

    private int offset = 10;

    public ConstraubtXOffsetRight(Element element) {
        this.element = element;
    }

    public ConstraubtXOffsetRight(Element element, int offset) {
        this.element = element;
        this.offset = offset;
    }

    @Override
    public int positionX(int width, int height, int elementWidth, int elementHeight) {
        return element.getData().x - element.getData().width - offset;
    }
}

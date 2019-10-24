package engine.uiBehavior;

import engine.ui.Element;

public class Collider {

    private Element element;

    public final void setElement(Element element) {
        this.element = element;
    }

    public final Element getElement() {
        return element;
    }

    public boolean colliding(Element element) {
        element.getData();
        return false;
    }

}

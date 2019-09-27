package engine.uiElements.elements;

import engine.uiElements.Element;
import engine.uiElements.ElementData;

import java.awt.*;

public class E3DRectangle extends Element {

    private boolean b = true;

    public E3DRectangle(Color color) {
        setColor(color);
    }

    public E3DRectangle(Color color, boolean b) {
        setColor(color);
        this.b = b;
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        g.setColor(getColor());
        g.draw3DRect(elementData.x, elementData.y, elementData.width, elementData.height, b);
    }

}

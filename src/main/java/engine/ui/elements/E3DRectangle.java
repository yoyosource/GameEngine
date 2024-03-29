package engine.ui.elements;

import engine.ui.Element;
import engine.ui.ElementData;

import java.awt.*;

public class E3DRectangle extends Element {

    private boolean b = true;

    private boolean filled = true;

    public E3DRectangle(Color color) {
        setColor(color);
    }

    public E3DRectangle(Color color, boolean b) {
        setColor(color);
        this.b = b;
    }

    public E3DRectangle(Color color, boolean b, boolean filled) {
        setColor(color);
        this.b = b;
        this.filled = filled;
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        setColor(g);
        if (!filled) {
            g.draw3DRect(elementData.x + xOffset, elementData.y + yOffset, elementData.width, elementData.height, b);
        } else {
            g.fill3DRect(elementData.x + xOffset, elementData.y + yOffset, elementData.width, elementData.height, b);
        }
    }

}

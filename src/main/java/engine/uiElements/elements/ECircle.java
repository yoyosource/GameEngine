package engine.uiElements.elements;

import engine.uiElements.Element;
import engine.uiElements.ElementData;

import java.awt.*;

public class ECircle extends Element {

    private boolean filled = true;

    public ECircle(Color color) {
        setColor(color);
    }

    public ECircle(Color color, boolean filled) {
        setColor(color);
        this.filled = filled;
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        g.setColor(getColor());
        if (elementData.width == -1) {
            if (!filled) {
                g.drawOval(elementData.x, elementData.y, elementData.height, elementData.height);
            } else {
                g.fillOval(elementData.x, elementData.y, elementData.height, elementData.height);
            }
        } else {
            if (!filled) {
                g.drawOval(elementData.x, elementData.y, elementData.width, elementData.width);
            } else {
                g.fillOval(elementData.x, elementData.y, elementData.width, elementData.width);
            }
        }
    }
}

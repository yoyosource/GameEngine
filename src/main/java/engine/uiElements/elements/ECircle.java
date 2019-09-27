package engine.uiElements.elements;

import engine.uiElements.Element;
import engine.uiElements.ElementData;

import java.awt.*;

public class ECircle extends Element {

    public ECircle(Color color) {
        setColor(color);
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        g.setColor(getColor());
        if (elementData.width == -1) {
            g.drawOval(elementData.x, elementData.y, elementData.height, elementData.height);
        } else {
            g.drawOval(elementData.x, elementData.y, elementData.width, elementData.width);
        }
    }
}

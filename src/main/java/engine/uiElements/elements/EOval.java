package engine.uiElements.elements;

import engine.uiElements.Element;
import engine.uiElements.ElementData;

import java.awt.*;

public class EOval extends Element {

    public EOval(Color color) {
        setColor(color);
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        g.setColor(getColor());
        g.drawOval(elementData.x, elementData.y, elementData.width, elementData.height);
    }

}

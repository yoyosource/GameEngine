package engine.ui.elements;

import engine.ui.Element;
import engine.ui.ElementData;

import java.awt.*;

public class ELine extends Element {

    public ELine(Color color) {
        setColor(color);
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        setColor(g);
        g.drawLine(elementData.x + xOffset, elementData.y + yOffset, elementData.x + xOffset + elementData.width, elementData.y + yOffset + elementData.height);
    }
}

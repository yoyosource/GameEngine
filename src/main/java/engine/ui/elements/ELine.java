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

        g.setColor(getColor());
        g.drawLine(elementData.x, elementData.y, elementData.x + elementData.width, elementData.y + elementData.height);
    }
}

package engine.uiElements.elements;

import engine.uiElements.Element;
import engine.uiElements.ElementData;

import java.awt.*;

public class EOval extends Element {

    private boolean filled = true;

    public EOval(Color color) {
        setColor(color);
    }

    public EOval(Color color, boolean filled) {
        setColor(color);
        this.filled = filled;
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        g.setColor(getColor());
        if (!filled) {
            g.drawOval(elementData.x, elementData.y, elementData.width, elementData.height);
        } else {
            g.fillOval(elementData.x, elementData.y, elementData.width, elementData.height);
        }
    }

}

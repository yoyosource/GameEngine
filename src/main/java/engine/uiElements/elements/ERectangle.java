package engine.uiElements.elements;

import engine.uiElements.Element;
import engine.uiElements.ElementData;

import java.awt.*;

public class ERectangle extends Element {

    private boolean filled = true;

    public ERectangle(Color color) {
        super.setColor(color);
    }

    public ERectangle(Color color, boolean filled) {
        super.setColor(color);
        this.filled = filled;
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        g.setColor(getColor());
        if (!filled) {
            g.drawRect(elementData.x, elementData.y, elementData.width, elementData.height);
        } else {
            g.fillRect(elementData.x, elementData.y, elementData.width, elementData.height);
        }
    }
}

package engine.ui.elements;

import engine.ui.Element;
import engine.ui.ElementData;

import java.awt.*;

public class EBorderedRectangle extends Element {

    private Color border;

    public EBorderedRectangle(Color color, Color border) {
        super.setColor(color);
        this.border = border;
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        setColor(g);
        g.drawRect(elementData.x + xOffset, elementData.y + yOffset, elementData.width, elementData.height);
        g.setColor(border);
        g.fillRect(elementData.x + xOffset, elementData.y + yOffset, elementData.width, elementData.height);
    }

}

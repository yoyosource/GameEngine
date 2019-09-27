package engine.uiElements.elements;

import engine.uiElements.Element;
import engine.uiElements.ElementData;

import java.awt.*;

public class EArc extends Element {

    private int startAngle = 0;
    private int endAngle = 360;

    public EArc(Color color) {
        setColor(color);
    }

    public EArc(Color color, int startAngle, int endAngle) {
        setColor(color);
        this.startAngle = startAngle;
        this.endAngle = endAngle;
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        g.setColor(getColor());
        g.drawArc(elementData.x, elementData.y, elementData.width, elementData.height, startAngle, endAngle);
    }
}

package engine.ui.elements;

import engine.ui.Element;
import engine.ui.ElementData;

import java.awt.*;

public class EArc extends Element {

    private int startAngle = 0;
    private int endAngle = 360;

    private boolean filled = true;

    public EArc(Color color) {
        setColor(color);
    }

    public EArc(Color color, boolean filled) {
        setColor(color);
        this.filled = filled;
    }

    public EArc(Color color, int startAngle, int endAngle) {
        setColor(color);
        this.startAngle = startAngle;
        this.endAngle = endAngle;
    }

    public EArc(Color color, int startAngle, int endAngle, boolean filled) {
        setColor(color);
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.filled = filled;
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        setColor(g);
        if (!filled) {
            g.drawArc(elementData.x + xOffset, elementData.y + yOffset, elementData.width, elementData.height, startAngle, endAngle);
        } else {
            g.fillArc(elementData.x + xOffset, elementData.y + yOffset, elementData.width, elementData.height, startAngle, endAngle);
        }
    }
}

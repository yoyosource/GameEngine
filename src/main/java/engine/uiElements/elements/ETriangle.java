package engine.uiElements.elements;

import engine.uiElements.Element;
import engine.uiElements.ElementData;

import java.awt.*;

public class ETriangle extends Element {

    private boolean filled = true;

    public ETriangle(Color color) {
        setColor(color);
    }

    public ETriangle(Color color, boolean filled) {
        setColor(color);
        this.filled = filled;
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        g.setColor(getColor());
        Polygon p = createPolygon(new int[]{elementData.x, elementData.x + elementData.width, elementData.x}, new int[]{elementData.y, elementData.y + elementData.height, elementData.y});
        if (!filled) {
            g.drawPolygon(p);
        } else {
            g.fillPolygon(p);
        }
    }

    public Polygon createPolygon(int[] x, int[] y) {
        Polygon p = new Polygon();
        p.xpoints = x;
        p.ypoints = y;
        p.npoints = x.length;
        return p;
    }

}

package engine.ui.elements;

import engine.ui.Element;
import engine.ui.ElementData;

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

        setColor(g);
        Polygon p = createPolygon(new int[]{elementData.x + xOffset, elementData.x + xOffset + elementData.width, elementData.x + xOffset}, new int[]{elementData.y + yOffset, elementData.y + yOffset, elementData.y + yOffset + elementData.height});
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

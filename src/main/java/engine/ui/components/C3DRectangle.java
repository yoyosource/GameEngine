package engine.ui.components;

import engine.ui.Element;
import engine.ui.ElementData;

import java.awt.*;

public class C3DRectangle extends Element {

    public C3DRectangle(Color color) {
        setColor(color);
    }

    public C3DRectangle(Color color, int posZ) {
        setColor(color);
        setPosZ(posZ);
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);
        /*setPosZ(getPosZ() % 10);
        setPosZ(getPosZ() + 0.001);
        if (getPosZ() < 1) {
            setPosZ(1);
        }*/

        setColor(g);

        elementData.x = (int)(elementData.x / (getPosZ() * getFov()));
        elementData.y = (int)(elementData.y / (getPosZ() * getFov()));
        elementData.width = (int)(elementData.width / (getPosZ() * getFov()));
        elementData.height = (int)(elementData.height / (getPosZ() * getFov()));
        g.fillRect(elementData.x + xOffset, elementData.y + yOffset, elementData.width, elementData.height);
    }

}

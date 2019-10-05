package engine.ui.elements;

import engine.ui.Element;
import engine.ui.ElementData;

import java.awt.*;

public class EText extends Element {

    private boolean filled = true;
    private String text;
    private Font font;

    public EText(Color color, String text) {
        font = new Font(Font.MONOSPACED, Font.PLAIN, 16);
        this.text = text;
        super.setColor(color);
    }

    public EText(Color color, String text, Font font) {
        this.text = text;
        super.setColor(color);
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        setColor(g);
        g.setFont(font);
        g.drawString(text, elementData.x + xOffset, elementData.y + yOffset);
    }

}

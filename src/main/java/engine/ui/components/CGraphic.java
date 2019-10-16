package engine.ui.components;

import engine.GameEngine;
import engine.ui.Element;
import engine.ui.ElementData;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.URL;

public class CGraphic extends Element {

    private BufferedImage image;

    public CGraphic(String s) throws IllegalArgumentException, IOException {
        image = ImageIO.read(GameEngine.class.getResource(s));
    }

    public CGraphic(URL url) throws IllegalArgumentException, IOException {
        image = ImageIO.read(url);
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        setColor(g);
        g.drawImage(image, elementData.x, elementData.y, elementData.width, elementData.height, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return true;
            }
        });
    }
}

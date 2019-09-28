package engine.ui;

import engine.constraints.Constraint;
import engine.constraints.Margin;
import engine.constraints.dimensions.ConstraintHeightFullscreen;
import engine.constraints.dimensions.ConstraintWidthFullscreen;
import engine.events.KeyHandler;
import engine.events.MouseHandler;
import engine.events.MouseMotionHandler;
import engine.events.MouseWheel;
import engine.uiBehavior.Event;
import engine.uiBehavior.Modifier;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Element {

    private Constraint constraint = new Constraint();
    private Color color;
    private Color nColor;
    private int fade = 0;
    private int maxFade = 0;
    private int fadeTime = 0;

    private ElementData elementData = new ElementData();

    private List<Modifier> modifiers = new ArrayList<>();
    private List<Event> events = new ArrayList<>();

    private List<Element> childs = new ArrayList<>();

    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        g.setColor(color);
    }

    public void drawChilds(Graphics2D g, int width, int height) {
        if (childs.isEmpty()) {
            return;
        }

        ElementData elementData = getData(width, height);
        for (Element element : childs) {
            element.modify(g, elementData.width, elementData.height);
            element.draw(g, elementData.width, elementData.height, elementData.x, elementData.y);
            element.drawChilds(g, elementData.width, elementData.height);
            element.modifyInvert(g, elementData.width, elementData.height);
        }
    }

    public void setConstraints(Constraint constraint) {
        this.constraint = constraint;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void addChild(Element element) {
        childs.add(element);
    }

    public void addModifier(Modifier modifier) {
        modifiers.add(modifier);
    }

    public void addEvent(Event event) {
        events.add(event);
        event.setElement(this);
    }

    public Color getColor() {
        return color;
    }

    protected void setColor(Graphics2D g) {
        /*
        !!! IMPORTANT !!!
        fixing synchronization issues accessing the variable maxFade and nColor.
         */
        int maxFadeLocal = this.maxFade;
        Color nColorLocal = null;

        synchronized (this) {
            if (maxFadeLocal > 0 && nColor != null) {
                nColorLocal = new Color(nColor.getRed(), nColor.getGreen(), nColor.getBlue(), nColor.getAlpha());
            }
        }

        if (maxFadeLocal > 0 && nColorLocal != null) {
            double changeR = (nColorLocal.getRed() - color.getRed()) / maxFadeLocal * fade;
            double changeG = (nColorLocal.getGreen() - color.getGreen()) / maxFadeLocal * fade;
            double changeB = (nColorLocal.getBlue() - color.getBlue()) / maxFadeLocal * fade;
            double changeA = (nColorLocal.getAlpha() - color.getAlpha()) / maxFadeLocal * fade;

            int R = color.getRed() + (int) changeR;
            if (R > 255) {
                R = 255;
            }
            if (R < 0) {
                R = 0;
            }

            int G = color.getGreen() + (int) changeG;
            if (G > 255) {
                G = 255;
            }
            if (G < 0) {
                G = 0;
            }

            int B = color.getBlue() + (int) changeB;
            if (B > 255) {
                B = 255;
            }
            if (B < 0) {
                B = 0;
            }

            int A = color.getAlpha() + (int) changeA;
            if (A > 255) {
                A = 255;
            }
            if (A < 0) {
                A = 0;
            }

            g.setColor(new Color(R, G, B, A));
            return;
        }
        if (nColor != null) {
            g.setColor(nColor);
        } else {
            g.setColor(color);
        }
    }

    protected ElementData getData(int width, int height) {
        ElementData elementData = new ElementData();

        if (constraint.getWidthConstraint().isRatio() && constraint.getHeightConstraint().isRatio()) {
            return elementData;
        }

        int w, h;

        if (constraint.getWidthConstraint().isRatio()) {
            h = constraint.getHeightConstraint().height(width, height, 0);
            w = constraint.getWidthConstraint().width(width, height, h);
        } else if (constraint.getHeightConstraint().isRatio()) {
            w = constraint.getWidthConstraint().width(width, height, 0);
            h = constraint.getHeightConstraint().height(width, height, w);
        } else {
            w = constraint.getWidthConstraint().width(width, height, 0);
            h = constraint.getHeightConstraint().height(width, height, 0);
        }

        int x = constraint.getXConstraint().positionX(width, height, w, h);
        int y = constraint.getYConstraint().positionY(width, height, w, h);

        Margin margin = constraint.getMargin();
        y += margin.getMarginUp();
        h -= margin.getMarginUp();
        h -= margin.getMarginDown();
        if (constraint.getHeightConstraint() instanceof ConstraintHeightFullscreen) {
            h -= margin.getMarginDown();
        }

        y += constraint.getOffset().getOffsetUp();

        x += margin.getMarginLeft();
        w -= margin.getMarginLeft();
        w -= margin.getMarginRight();
        if (constraint.getWidthConstraint() instanceof ConstraintWidthFullscreen) {
            w -= margin.getMarginRight();
        }

        x += constraint.getOffset().getOffsetLeft();

        elementData.x = x;
        elementData.y = y;
        elementData.width = w;
        elementData.height = h;

        this.elementData = elementData;

        return elementData;
    }

    public ElementData getData() {
        return elementData;
    }

    public void modify(Graphics2D g, int width, int height) {
        for (Modifier modifier : modifiers) {
            modifier.modify(g);
            modifier.modify(g, width, height);
        }
    }

    public void modifyInvert(Graphics2D g, int width, int height) {
        for (Modifier modifier : modifiers) {
            modifier.modifyInvert(g);
            modifier.modifyInvert(g, width, height);
        }
    }

    public void setnColor(Color color) {
        synchronized (this) {
            nColor = color;
        }
    }

    public void setMaxFade(int fadeTime) {
        this.fadeTime = fadeTime;
    }

    public void update(KeyHandler keyHandler, MouseHandler mouseHandler, MouseMotionHandler mouseMotionHandler, MouseWheel mouseWheel) {
        for (Modifier modifier : modifiers) {
            modifier.update(keyHandler);
        }
        setnColor(null);
        setMaxFade(0);
        for (Event event : events) {
            if (event.isEventToggle(keyHandler, mouseHandler, mouseMotionHandler, mouseWheel)) {
                event.run();
            }
        }
        if (fadeTime == 0) {
            fade = 0;
        } else if (fade < maxFade) {
            fade++;
        }
        maxFade = fadeTime;
        if (!childs.isEmpty()) {
            for (Element element : childs) {
                element.update(keyHandler, mouseHandler, mouseMotionHandler, mouseWheel);
            }
        }
    }

}

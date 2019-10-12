package engine.ui;

import engine.constraints.Constraint;
import engine.constraints.Margin;
import engine.constraints.dimensions.ConstraintHeightFullscreen;
import engine.constraints.dimensions.ConstraintWidthFullscreen;
import engine.events.KeyHandler;
import engine.events.MouseHandler;
import engine.events.MouseMotionHandler;
import engine.events.MouseWheel;
import engine.uiBehavior.Action;
import engine.uiBehavior.Event;
import engine.uiBehavior.Modifier;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Element is the class to draw any thing on the view.
 */
public class Element {

    private Constraint constraint = new Constraint();
    private Color color;
    private Color nColor;
    private Color nColorChange;
    private int fade = 0;
    private int maxFade = 0;
    private int fadeTime = 0;
    private double fov = 1;
    private double posZ = 1;
    private double posZChange = 0;

    private ElementData elementData = new ElementData();

    private List<Modifier> modifiers = new ArrayList<>();
    private List<Event> events = new ArrayList<>();

    private List<Element> childs = new ArrayList<>();

    private boolean hide = false;
    private boolean hide2 = false;

    private List<Action> action = new ArrayList<>();

    /**
     * This draws the object you want to draw.
     *
     * This method should be overridden from subclasses of Element.
     *
     * @param g
     * @param width
     * @param height
     * @param xOffset
     * @param yOffset
     */
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        setColor(g);
    }

    /**
     * drawChilds will draw every Children element of this Element.
     *
     * Don't override this method.
     *
     * @param g
     * @param width
     * @param height
     */
    public final void drawChilds(Graphics2D g, int width, int height) {
        if (hide) {
            return;
        }
        if (childs.isEmpty()) {
            return;
        }

        ElementData elementData = getData(width, height);
        for (Element element : childs) {
            element.modify(g, elementData.width, elementData.height, (posZ + posZChange) * fov);
            element.draw(g, elementData.width, elementData.height, elementData.x, elementData.y);
            element.drawChilds(g, elementData.width, elementData.height);
            element.modifyInvert(g, elementData.width, elementData.height, (posZ + posZChange) * fov);
        }
    }

    /**
     * setConstraints is used to set the Constraints of the Element.
     *
     * Don't override this method.
     *
     * @param constraint
     */
    public final void setConstraints(Constraint constraint) {
        this.constraint = constraint;
    }

    /**
     * setColor is used to set the normal color of the Element.
     *
     * Don't override this method.
     *
     * @param color
     */
    public final void setColor(Color color) {
        this.color = color;
    }

    /**
     * Use this Method to add new Children to the Element.
     *
     * Don't override this method.
     *
     * @param element
     */
    public void addChild(Element element) {
        childs.add(element);
    }

    /**
     * Use this Method to add new Modifiers to the Element.
     *
     * Don't override this method.
     *
     * @param modifier
     */
    public void addModifier(Modifier modifier) {
        modifiers.add(modifier);
    }

    public void addEvent(Event event) {
        events.add(event);
        event.setElement(this);
    }

    /**
     * getColor is used to get the default color of the element.
     *
     * Expected use in Actions.
     * Don't override this method.
     *
     * @return
     */
    public final Color getColor() {
        return color;
    }


    /**
     * setColor will set the correct color to the view if any fade or colorChange happened.
     *
     * Don't override this method.
     *
     * @param g
     */
    protected final void setColor(Graphics2D g) {
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

    /**
     * This Method is used for evaluating the constraints to the x, y, width and height of the Element.
     *
     * Don't override this method.
     *
     * @param width
     * @param height
     * @return
     */
    protected final ElementData getData(int width, int height) {
        /*
        !!! IMPORTANT !!!
        fixing synchronization issues accessing the variable hide.
         */
        boolean hideLocal = hide;

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

        this.elementData = new ElementData();
        this.elementData.x = x;
        this.elementData.y = y;
        this.elementData.width = w;
        this.elementData.height = h;

        if (hideLocal) {
            x -= width - w - 10;
            y -= height - h - 10;
        }

        elementData.x = x;
        elementData.y = y;
        elementData.width = w;
        elementData.height = h;

        return elementData;
    }

    /**
     * Get the ElementData from the last update of the Element.
     *
     * Don't override this method.
     *
     * @return
     */
    public final ElementData getData() {
        return elementData;
    }

    /**
     * modify modifies the View.
     *
     * Don't override this method.
     *
     * @param g
     * @param width
     * @param height
     */
    public final void modify(Graphics2D g, int width, int height, double rate) {
        for (Modifier modifier : modifiers) {
            modifier.modify(g, rate);
            modifier.modify(g, width, height, rate);
        }
    }

    /**
     * modifyInvert modifies the View inverse to the modifications in modify.
     * @see #modify
     *
     * Don't override this method.
     *
     * @param g
     * @param width
     * @param height
     */
    public final void modifyInvert(Graphics2D g, int width, int height, double rate) {
        for (Modifier modifier : modifiers) {
            modifier.modifyInvert(g, rate);
            modifier.modifyInvert(g, width, height, rate);
        }
    }

    /**
     * setnColor is used to change the Color of the Element.
     * Only use this Method in an Action or subclasses.
     *
     * Don't override this method.
     *
     * @param color
     */
    public final void setnColor(Color color) {
        nColorChange = color;
    }

    /**
     * setMaxFade is used to change the Fade Time to the updates it should take to fade from the base color to the new Color.
     * Only use this Method in an Action or subclasses.
     *
     * Don't override this method.
     *
     * @param fadeTime
     */
    public final void setMaxFade(int fadeTime) {
        this.fadeTime = fadeTime;
    }

    /**
     * setHide is used to Hide the Element from the view.
     * Only use this Method in an Action or subclasses.
     *
     * Don't override this method.
     *
     * @param hide
     */
    public final void setHide(boolean hide) {
        this.hide2 = hide;
    }

    /**
     * Remove a specific Action from this Element.
     *
     * Don't override this method.
     *
     * @param action
     */
    public final void removeAction(Action action) {
        this.action.remove(action);
    }

    /**
     * Add a specific Action to this Element.
     *
     * Don't override this method.
     *
     * @param action
     */
    public final void addAction(Action action) {
        this.action.add(action);
    }

    /**
     * update is used to update some things in Element.
     *
     * Don't override this method.
     *
     * @param keyHandler
     * @param mouseHandler
     * @param mouseMotionHandler
     * @param mouseWheel
     */
    public final void update(KeyHandler keyHandler, MouseHandler mouseHandler, MouseMotionHandler mouseMotionHandler, MouseWheel mouseWheel, double fov, double posZ) {
        this.fov = fov;
        this.posZChange = posZ;
        for (Modifier modifier : modifiers) {
            modifier.update(keyHandler);
        }
        setHide(false);
        setnColor(null);
        setMaxFade(0);
        for (Event event : events) {
            if (hide && !event.runWhenHidden()) {
                continue;
            }
            if (event.isEventToggle(keyHandler, mouseHandler, mouseMotionHandler, mouseWheel)) {
                event.run();
            }
        }
        if (!action.isEmpty()) {
            for (Action action : action) {
                action.run();
            }
        }
        if (fadeTime == 0) {
            fade = 0;
        } else if (fade < maxFade) {
            fade++;
        }
        maxFade = fadeTime;
        hide = hide2;
        if (nColorChange == null) {
            nColor = null;
        } else {
            int r = nColorChange.getRed();
            int g = nColorChange.getGreen();
            int b = nColorChange.getBlue();
            int a = nColorChange.getAlpha();
            nColor = new Color(r, g, b, a);
        }
        if (!childs.isEmpty()) {
            for (Element element : childs) {
                element.update(keyHandler, mouseHandler, mouseMotionHandler, mouseWheel, fov, posZ);
            }
        }
    }

    public final double getFov() {
        return fov;
    }

    /**
     * elementCount is used to count every child element of this element.
     *
     * Don't override this method.
     *
     * @return
     */
    public final int elementCount() {
        int count = childs.size();
        for (Element element : childs) {
            count += element.elementCount();
        }
        return count;
    }

    public final void setPosZ(double posZ) {
        this.posZ = posZ;
    }

    public final double getPosZ() {
        return posZ + posZChange;
    }

    public final double getPosZRaw() {
        return posZ;
    }

}

package engine.ui;

import engine.constraints.Constraint;
import engine.constraints.Margin;
import engine.constraints.dimensions.ConstraintHeightFullscreen;
import engine.constraints.dimensions.ConstraintWidthFullscreen;
import engine.events.KeyHandler;
import engine.modifier.Modifier;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Element {

    private Constraint constraint = new Constraint();
    private Color color;

    private List<Modifier> modifiers = new ArrayList<>();

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

    protected Color getColor() {
        return color;
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

    public void update(KeyHandler keyHandler) {
        for (Modifier modifier : modifiers) {
            modifier.update(keyHandler);
        }
        if (!childs.isEmpty()) {
            for (Element element : childs) {
                element.update(keyHandler);
            }
        }
    }

}

package engine.ui.components;

import engine.constraints.Constraint;
import engine.constraints.Margin;
import engine.constraints.dimensions.ConstraintHeightFullscreen;
import engine.constraints.dimensions.ConstraintWidthFixed;
import engine.constraints.dimensions.ConstraintWidthPercent;
import engine.constraints.locations.ConstraintXFixed;
import engine.constraints.locations.ConstraintXFixedRight;
import engine.constraints.locations.ConstraintYFixed;
import engine.ui.Element;
import engine.ui.ElementData;

import java.awt.*;

public class CSidebar extends Element {

    private int top = 0;
    private int bottom = 0;
    private int side = 0;

    private double width = 0.0;
    private boolean isFixed = false;

    private boolean left = true;

    public CSidebar(int top, int bottom, int side, int width) {
        setColor(getDefault());

        this.top = top;
        this.bottom = bottom;
        this.side = side;

        this.width = width;
        setConstraints();
    }

    public CSidebar(Color color, int top, int bottom, int side, int width) {
        setColor(color);

        this.top = top;
        this.bottom = bottom;
        this.side = side;

        this.width = width;
        setConstraints();
    }

    public CSidebar(Color color, int top, int bottom, int side, int width, boolean fixed) {
        setColor(color);

        this.top = top;
        this.bottom = bottom;
        this.side = side;

        this.width = width;
        this.isFixed = fixed;
        setConstraints();
    }

    public CSidebar(int top, int bottom, int side, double width) {
        setColor(getDefault());

        this.top = top;
        this.bottom = bottom;
        this.side = side;

        this.width = width;
        setConstraints();
    }

    public CSidebar(Color color, int top, int bottom, int side, double width) {
        setColor(color);

        this.top = top;
        this.bottom = bottom;
        this.side = side;

        this.width = width;
        setConstraints();
    }

    public CSidebar(Color color, int top, int bottom, int side, double width, boolean fixed) {
        setColor(color);

        this.top = top;
        this.bottom = bottom;
        this.side = side;

        this.width = width;
        this.isFixed = fixed;
        setConstraints();
    }

    public void setRight() {
        left = false;
        setConstraints();
    }

    public void setLeft() {
        left = true;
        setConstraints();
    }

    private void setConstraints() {
        Constraint sideBarConstraint = new Constraint();
        Margin sideBarMargin = new Margin();
        sideBarMargin.setMarginDown(bottom);
        sideBarConstraint.setMargin(sideBarMargin);
        if (left) {
            sideBarConstraint.setXConstraint(new ConstraintXFixed(side));
        } else {
            sideBarConstraint.setXConstraint(new ConstraintXFixedRight(side));
        }
        sideBarConstraint.setYConstraint(new ConstraintYFixed(top));
        sideBarConstraint.setHeightConstraint(new ConstraintHeightFullscreen());
        if (isFixed) {
            sideBarConstraint.setWidthConstraint(new ConstraintWidthFixed((int)width));
        } else {
            sideBarConstraint.setWidthConstraint(new ConstraintWidthPercent(width));
        }
        super.setConstraints(sideBarConstraint);
    }

    public static Color getDefault() {
        return new Color(100, 100, 100, 100);
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        setColor(g);
        g.fillRect(elementData.x + xOffset, elementData.y + yOffset, elementData.width, elementData.height);
    }

}

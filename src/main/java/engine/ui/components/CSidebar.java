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
import engine.ui.elements.ERectangle;

import java.awt.*;

public class CSidebar {

    private int top = 0;
    private int bottom = 0;
    private int side = 0;

    private double width = 0.0;
    private boolean isFixed = false;

    public CSidebar(int top, int bottom, int side, int width) {
        this.top = top;
        this.bottom = bottom;
        this.side = side;

        this.width = width;
    }

    public CSidebar(int top, int bottom, int side, int width, boolean fixed) {
        this.top = top;
        this.bottom = bottom;
        this.side = side;

        this.width = width;
        this.isFixed = fixed;
    }

    public CSidebar(int top, int bottom, int side, double width) {
        this.top = top;
        this.bottom = bottom;
        this.side = side;

        this.width = width;
    }

    public CSidebar(int top, int bottom, int side, double width, boolean fixed) {
        this.top = top;
        this.bottom = bottom;
        this.side = side;

        this.width = width;
        this.isFixed = fixed;
    }

    public Element getSidebarRight() {
        ERectangle sideBarRight = new ERectangle(new Color(100, 100, 100, 100));
        Constraint sideBarRightConstraint = new Constraint();
        Margin sideBarMargin = new Margin();
        sideBarMargin.setMarginDown(bottom);
        sideBarRightConstraint.setMargin(sideBarMargin);
        sideBarRightConstraint.setXConstraint(new ConstraintXFixedRight(side));
        sideBarRightConstraint.setYConstraint(new ConstraintYFixed(top));
        sideBarRightConstraint.setHeightConstraint(new ConstraintHeightFullscreen());
        if (isFixed) {
            sideBarRightConstraint.setWidthConstraint(new ConstraintWidthFixed((int)width));
        } else {
            sideBarRightConstraint.setWidthConstraint(new ConstraintWidthPercent(width));
        }
        sideBarRight.setConstraints(sideBarRightConstraint);
        return sideBarRight;
    }

    public Element getSidebarLeft() {
        ERectangle sideBarLeft = new ERectangle(new Color(100, 100, 100, 100));
        Constraint sideBarLeftConstraint = new Constraint();
        Margin sideBarMargin = new Margin();
        sideBarMargin.setMarginDown(bottom);
        sideBarLeftConstraint.setMargin(sideBarMargin);
        sideBarLeftConstraint.setXConstraint(new ConstraintXFixed(side));
        sideBarLeftConstraint.setYConstraint(new ConstraintYFixed(top));
        sideBarLeftConstraint.setHeightConstraint(new ConstraintHeightFullscreen());
        if (isFixed) {
            sideBarLeftConstraint.setWidthConstraint(new ConstraintWidthFixed((int)width));
        } else {
            sideBarLeftConstraint.setWidthConstraint(new ConstraintWidthPercent(width));
        }
        sideBarLeft.setConstraints(sideBarLeftConstraint);
        return sideBarLeft;
    }

}

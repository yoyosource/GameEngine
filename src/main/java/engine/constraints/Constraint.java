package engine.constraints;

import engine.constraints.constraintInterfaces.HeightConstraint;
import engine.constraints.constraintInterfaces.WidthConstraint;
import engine.constraints.constraintInterfaces.XConstraint;
import engine.constraints.constraintInterfaces.YConstraint;

public class Constraint {

    private WidthConstraint widthConstraint = new WidthConstraint();
    private HeightConstraint heightConstraint = new HeightConstraint();

    private XConstraint xConstraint = new XConstraint();
    private YConstraint yConstraint = new YConstraint();

    private Margin margin = new Margin();

    public void setWidthConstraint(WidthConstraint widthConstraint) {
        this.widthConstraint = widthConstraint;
    }

    public void setHeightConstraint(HeightConstraint heightConstraint) {
        this.heightConstraint = heightConstraint;
    }

    public void setXConstraint(XConstraint xConstraint) {
        this.xConstraint = xConstraint;
    }

    public void setYConstraint(YConstraint yConstraint) {
        this.yConstraint = yConstraint;
    }

    public void setMargin(Margin margin) {
        this.margin = margin;
    }

    public WidthConstraint getWidthConstraint() {
        return widthConstraint;
    }

    public HeightConstraint getHeightConstraint() {
        return heightConstraint;
    }

    public XConstraint getXConstraint() {
        return xConstraint;
    }

    public YConstraint getYConstraint() {
        return yConstraint;
    }

    public Margin getMargin() {
        return margin;
    }
}

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

    public void setWidthConstraint(WidthConstraint widthConstraint) {
        this.widthConstraint = widthConstraint;
    }

    public void setHeightConstraint(HeightConstraint heightConstraint) {
        this.heightConstraint = heightConstraint;
    }

    public void setxConstraint(XConstraint xConstraint) {
        this.xConstraint = xConstraint;
    }

    public void setyConstraint(YConstraint yConstraint) {
        this.yConstraint = yConstraint;
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
}

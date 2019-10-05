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
    private Offset offset = new Offset();

    public Constraint() {

    }

    public Constraint(WidthConstraint widthConstraint, HeightConstraint heightConstraint, XConstraint xConstraint, YConstraint yConstraint) {
        this.widthConstraint = widthConstraint;
        this.heightConstraint = heightConstraint;
        this.xConstraint = xConstraint;
        this.yConstraint = yConstraint;
    }

    public Constraint(WidthConstraint widthConstraint, HeightConstraint heightConstraint, XConstraint xConstraint, YConstraint yConstraint, Margin margin) {
        this.widthConstraint = widthConstraint;
        this.heightConstraint = heightConstraint;
        this.xConstraint = xConstraint;
        this.yConstraint = yConstraint;
        this.margin = margin;
    }

    public Constraint(WidthConstraint widthConstraint, HeightConstraint heightConstraint, XConstraint xConstraint, YConstraint yConstraint, Offset offset) {
        this.widthConstraint = widthConstraint;
        this.heightConstraint = heightConstraint;
        this.xConstraint = xConstraint;
        this.yConstraint = yConstraint;
        this.offset = offset;
    }

    public Constraint(WidthConstraint widthConstraint, HeightConstraint heightConstraint, XConstraint xConstraint, YConstraint yConstraint, Margin margin, Offset offset) {
        this.widthConstraint = widthConstraint;
        this.heightConstraint = heightConstraint;
        this.xConstraint = xConstraint;
        this.yConstraint = yConstraint;
        this.margin = margin;
        this.offset = offset;
    }

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

    public void setOffset(Offset offset) {
        this.offset = offset;
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

    public Offset getOffset() {
        return offset;
    }
}

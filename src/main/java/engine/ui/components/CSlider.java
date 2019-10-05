package engine.ui.components;

import engine.constraints.Constraint;
import engine.constraints.dimensions.ConstraintHeightFixed;
import engine.constraints.dimensions.ConstraintWidthFixed;
import engine.constraints.dimensions.ConstraintWidthPercent;
import engine.constraints.locations.ConstraintXCenter;
import engine.constraints.locations.ConstraintYFixed;
import engine.ui.Element;
import engine.ui.ElementData;
import engine.uiBehavior.Action;
import engine.uiBehavior.Event;
import engine.uiBehavior.events.EventChangeValue;
import engine.uiBehavior.events.EventHold;

import java.awt.*;

public class CSlider extends Element {

    private double width = 0;
    private boolean fixed = false;
    private int top = 0;

    private double value = 0.5;

    private EventChangeValue eventChangeValue;

    public CSlider(Color color, int top, int width) {
        setColor(color);
        this.top = top;
        fixed = true;
        this.width = width;

        setConstraints();
        setActions();
    }

    public CSlider(Color color, int top, double width) {
        setColor(color);
        this.top = top;
        this.width = width;

        setConstraints();
        setActions();
    }

    private void setConstraints() {
        Constraint sliderConstraint = new Constraint();
        sliderConstraint.setXConstraint(new ConstraintXCenter());
        sliderConstraint.setYConstraint(new ConstraintYFixed(top - 8));
        sliderConstraint.setHeightConstraint(new ConstraintHeightFixed(20));
        if (fixed) {
            sliderConstraint.setWidthConstraint(new ConstraintWidthFixed((int)width));
        } else {
            sliderConstraint.setWidthConstraint(new ConstraintWidthPercent(width));
        }
        super.setConstraints(sliderConstraint);
    }

    private void setActions() {
        eventChangeValue = new EventChangeValue();
        EventHold eventHold = new EventHold();
        Action action = new Action(){
            @Override
            public void run() {
                Point pos = eventHold.getPos();
                ElementData elementData = getData();
                int x = pos.x - elementData.x;
                value = x / (double)elementData.width;
                if (value < 0) {
                    value = 0;
                }
                if (value > 1) {
                    value = 1;
                }
                eventChangeValue.setCurrentValue(value);
            }
        };
        eventHold.addAction(action);
        super.addEvent(eventHold);
        super.addEvent(eventChangeValue);
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        ElementData elementData = getData(width, height);

        setColor(g);
        g.fillRect(elementData.x + xOffset, elementData.y + yOffset + 8, elementData.width, 4);
        g.fillRect(elementData.x - 2 + (int)(elementData.width * value) + xOffset, elementData.y + yOffset, 4, 20);
    }

    public void addChangeAction(Action action) {
        eventChangeValue.addAction(action);
    }

    public double getValue() {
        return eventChangeValue.getValue();
    }

    @Override
    public void addEvent(Event event) {

    }

    @Override
    public void addChild(Element element) {

    }
}

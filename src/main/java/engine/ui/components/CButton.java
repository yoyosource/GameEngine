package engine.ui.components;

import engine.constraints.Constraint;
import engine.ui.Element;
import engine.ui.ElementData;
import engine.uiBehavior.Action;
import engine.uiBehavior.Event;
import engine.uiBehavior.events.EventChangeValue;
import engine.uiBehavior.events.EventClick;
import engine.uiBehavior.events.EventHover;

import java.awt.*;

public class CButton extends Element {

    private EventChangeValue eventChangeValue;

    public CButton(Color color, Constraint constraint) {
        setColor(color);
        setConstraints(constraint);

        setActions();
    }

    private void setActions() {
        eventChangeValue = new EventChangeValue();
        EventHover eventHover = new EventHover();
        eventHover.addAction(new Action(){
            @Override
            public void run() {
                eventChangeValue.setCurrentValue(0);
            }
        });
        EventClick eventClick = new EventClick();
        eventClick.addAction(new Action(){
            @Override
            public void run() {
                eventChangeValue.setCurrentValue(1);
            }
        });
        super.addEvent(eventHover);
        super.addEvent(eventClick);
        super.addEvent(eventChangeValue);
    }

    public void addChangeAction(Action action) {
        eventChangeValue.addAction(action);
    }

    @Override
    public void draw(Graphics2D g, int width, int height, int xOffset, int yOffset) {
        setColor(g);
        ElementData elementData = getData(width, height);

        setColor(g);
        g.fillRect(elementData.x + xOffset, elementData.y + yOffset, elementData.width, elementData.height);
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

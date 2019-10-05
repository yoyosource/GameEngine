package engine.uiBehavior.events;

import engine.events.KeyHandler;
import engine.events.MouseHandler;
import engine.events.MouseMotionHandler;
import engine.events.MouseWheel;
import engine.uiBehavior.Event;

public class EventChangeValue extends Event {

    private double lastValue = 0;
    private double currentValue = 0;

    @Override
    public boolean isEventToggle(KeyHandler keyHandler, MouseHandler mouseHandler, MouseMotionHandler mouseMotionHandler, MouseWheel mouseWheel) {
        boolean b = lastValue != currentValue;
        lastValue = currentValue;
        return b;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public double getValue() {
        return currentValue;
    }
}

package test;

import engine.GameEngine;
import engine.constraints.Constraint;
import engine.constraints.Margin;
import engine.constraints.dimensions.*;
import engine.constraints.locations.*;
import engine.ui.components.CSidebar;
import engine.ui.components.CSlider;
import engine.ui.elements.ERectangle;
import engine.uiBehavior.Action;
import engine.uiBehavior.actions.*;
import engine.uiBehavior.events.*;
import engine.uiBehavior.modifier.ModifierRotateDynamic;

import java.awt.*;

public class Test {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine("Test", Toolkit.getDefaultToolkit().getScreenSize().width / 4 * 3, Toolkit.getDefaultToolkit().getScreenSize().height / 4 * 3);
        gameEngine.setUpdateTime(120);
        gameEngine.setMinSize(Toolkit.getDefaultToolkit().getScreenSize().width / 4 * 3, Toolkit.getDefaultToolkit().getScreenSize().height / 4 * 3);

        CSidebar sidebar = new CSidebar(10, 10, 10, 0.225);
        EventClick eventHover = new EventClick(true);
        eventHover.addAction(new ActionToggle(new ActionHide()));
        gameEngine.addElement(sidebar);

        CSlider cSlider = new CSlider(new Color(100, 100, 100, 255), 15, 0.9);
        sidebar.addChild(cSlider);
        Action action = new Action(){
            @Override
            public void run() {
                System.out.println("hi");
            }
        };
        cSlider.addChangeAction(action);

        System.out.println(gameEngine.elementCount());
    }

}


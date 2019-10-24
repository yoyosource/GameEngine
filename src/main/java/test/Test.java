package test;

import engine.GameEngine;
import engine.constraints.Constraint;
import engine.constraints.dimensions.*;
import engine.constraints.locations.*;
import engine.ui.components.CSidebar;
import engine.ui.components.CSlider;
import engine.ui.elements.ERectangle;
import engine.uiBehavior.Action;
import engine.uiBehavior.actions.*;
import engine.uiBehavior.events.*;

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
        cSlider.addChangeAction(new Action(){
            @Override
            public void run() {
                //System.out.println(cSlider.getValue());
            }
        });

        /*
        CButton cButton = new CButton(new Color(200, 200, 200, 255), new Constraint(new ConstraintWidthPercent(0.5), new ConstraintHeightPercent(0.5), new ConstraintXCenter(), new ConstraintYCenter()));
        sidebar.addChild(cButton);
        */

        ERectangle eRectangle = new ERectangle(new Color(120, 0, 255, 255), true);
        eRectangle.setConstraints(new Constraint(new ConstraintWidthPercent(0.5), new ConstraintHeightRatio(0.5), new ConstraintXCenter(), new ConstraintYCenter()));
        EventClick eventClick = new EventClick();
        eventClick.runWhenHidden();
        eventClick.addAction(new ActionToggle(new ActionAlphaFade(0, 100)));
        eventClick.addAction(new ActionToggle(new ActionMove()));
        eRectangle.addEvent(eventClick);

        sidebar.addChild(eRectangle);

        /*
        gameEngine.addModifier(new ModifierTranslateCenter());
        gameEngine.addModifier(new ModifierTranslateMovements('w', 's', 'd', 'a', ' ', '\uFFFF'));

        C3DRectangle c3DRectangle1 = new C3DRectangle(new Color(0, 0, 0, 255));
        Constraint constraint1 = new Constraint();
        constraint1.setXConstraint(new ConstraintXWidthCenter());
        constraint1.setYConstraint(new ConstraintYHeightCenter());
        constraint1.setWidthConstraint(new ConstraintWidthFixed(100));
        constraint1.setHeightConstraint(new ConstraintHeightFixed(100));
        c3DRectangle1.setConstraints(constraint1);
        gameEngine.addElement(c3DRectangle1);

        C3DRectangle c3DRectangle2 = new C3DRectangle(new Color(0, 0, 0, 255));
        Constraint constraint2 = new Constraint();
        constraint2.setXConstraint(new ConstraintXWidthCenter());
        constraint2.setYConstraint(new ConstraintYHeightCenter());
        constraint2.setWidthConstraint(new ConstraintWidthFixed(100));
        constraint2.setHeightConstraint(new ConstraintHeightFixed(100));
        c3DRectangle2.addModifier(new ModifierTranslate(150, 200));
        c3DRectangle2.setConstraints(constraint2);
        gameEngine.addElement(c3DRectangle2);
        */

        System.out.println(gameEngine.elementCount());
    }
}


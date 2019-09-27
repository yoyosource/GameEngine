package test;

import engine.GameEngine;
import engine.constraints.Constraint;
import engine.constraints.Margin;
import engine.constraints.dimensions.*;
import engine.constraints.locations.*;
import engine.ui.elements.ERectangle;

import java.awt.*;

public class Test {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine("Test", Toolkit.getDefaultToolkit().getScreenSize().width / 4 * 3, Toolkit.getDefaultToolkit().getScreenSize().height / 4 * 3);
        gameEngine.setUpdateTime(120);
        gameEngine.setMinSize(Toolkit.getDefaultToolkit().getScreenSize().width / 4 * 3, Toolkit.getDefaultToolkit().getScreenSize().height / 4 * 3);

        ERectangle sideBarLeft = new ERectangle(new Color(100, 100, 100, 100));
        Constraint sideBarLeftConstraint = new Constraint();
        Margin sideBarMargin = new Margin();
        sideBarMargin.setMarginDown(10);
        sideBarLeftConstraint.setMargin(sideBarMargin);
        sideBarLeftConstraint.setXConstraint(new ConstraintXFixed(10));
        sideBarLeftConstraint.setYConstraint(new ConstraintYFixed(10));
        sideBarLeftConstraint.setHeightConstraint(new ConstraintHeightFullscreen());
        sideBarLeftConstraint.setWidthConstraint(new ConstraintWidthPercent(0.225));
        sideBarLeft.setConstraints(sideBarLeftConstraint);
        gameEngine.addElement(sideBarLeft);

        System.out.println(gameEngine.elementCount());
    }

}


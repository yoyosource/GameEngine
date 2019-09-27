package test;

import engine.GameEngine;
import engine.constraints.Constraint;
import engine.constraints.dimensions.*;
import engine.constraints.locations.*;
import engine.modifier.ModifierRotateDynamic;
import engine.modifier.ModifierTranslateCenter;
import engine.modifier.ModifierTranslateMovements;
import engine.uiElements.elements.EBorderedRectangle;
import engine.uiElements.elements.ERectangle;

import java.awt.*;

public class Test {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine("Test", 100, 100);
        gameEngine.setUpdateTime(120);

        ERectangle eRectangle = new ERectangle(new Color(0, 0, 0), true);
        Constraint constraint = new Constraint();
        constraint.setWidthConstraint(new ConstraintWidthPercent(0.1));
        constraint.setHeightConstraint(new ConstraintHeightRatio(1));
        constraint.setxConstraint(new ConstraintXWidthCenter());
        constraint.setyConstraint(new ConstraintYHeightCenter());
        eRectangle.setConstraints(constraint);
        eRectangle.addModifier(new ModifierTranslateMovements('W', 'S', 'D', 'A', -2));
        eRectangle.addModifier(new ModifierTranslateMovements('w', 's', 'd', 'a', -2));
        eRectangle.addModifier(new ModifierRotateDynamic(Math.PI / 360));

        EBorderedRectangle eBorderedRectangle = new EBorderedRectangle(new Color(255, 255, 255), new Color(255, 255, 255));
        Constraint constraint1 = new Constraint();
        constraint1.setWidthConstraint(new ConstraintWidthPercent(0.5));
        constraint1.setHeightConstraint(new ConstraintHeightRatio(1));
        constraint1.setxConstraint(new ConstraintXCenter());
        constraint1.setyConstraint(new ConstraintYCenter());
        eBorderedRectangle.setConstraints(constraint1);
        eBorderedRectangle.addModifier(new ModifierRotateDynamic(Math.PI / -180));

        eRectangle.addChild(eBorderedRectangle);

        ERectangle eRectangle1 = new ERectangle(new Color(255, 0, 0), true);
        eRectangle1.setConstraints(constraint);
        gameEngine.addElement(eRectangle1);

        gameEngine.addElement(eRectangle);

        if (true) {
            ERectangle eRectangle2 = new ERectangle(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)), false);
            Constraint constraint2 = new Constraint();
            constraint2.setWidthConstraint(new ConstraintWidthPercent(0.1));
            constraint2.setHeightConstraint(new ConstraintHeightRatio(1));
            constraint2.setxConstraint(new ConstraintXPercentage(Math.random()));
            constraint2.setyConstraint(new ConstraintYPercentage(Math.random()));
            eRectangle2.setConstraints(constraint2);
            eRectangle2.setConstraints(constraint);
            gameEngine.addElement(eRectangle2);
        }

        gameEngine.addModifier(new ModifierTranslateCenter());
        gameEngine.addModifier(new ModifierTranslateMovements('W', 'S', 'D', 'A', 2));
        gameEngine.addModifier(new ModifierTranslateMovements('w', 's', 'd', 'a', 2));
        //gameEngine.addModifier(new ModifierRotateDynamic(Math.PI / 360));

        System.out.println(gameEngine.elementCount());
    }

}

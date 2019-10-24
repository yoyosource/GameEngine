package engine;

import engine.events.KeyHandler;
import engine.events.MouseHandler;
import engine.events.MouseMotionHandler;
import engine.events.MouseWheel;
import engine.uiBehavior.Modifier;
import engine.ui.Element;
import engine.uiBehavior.modifier.ModifierTranslateMovements;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer extends JComponent {

    private List<Element> elementList = new ArrayList<>();

    private List<Modifier> modifiers = new ArrayList<>();

    private double fov = 1;
    private double posZ = 0;

    private KeyHandler keyHandler;
    private MouseHandler mouseHandler;
    private MouseMotionHandler mouseMotionHandler;
    private MouseWheel mouseWheel;

    private long time = System.currentTimeMillis();
    private int fps = 0;

    public Renderer(KeyHandler keyHandler, MouseHandler mouseHandler, MouseMotionHandler mouseMotionHandler, MouseWheel mouseWheel) {
        this.keyHandler = keyHandler;
        this.mouseHandler = mouseHandler;
        this.mouseMotionHandler = mouseMotionHandler;
        this.mouseWheel = mouseWheel;
    }

    public void addElement(Element element) {
        elementList.add(element);
    }

    public void addModifier(Modifier modifier) { this.modifiers.add(modifier); }

    public void setFov(double fov) {
        this.fov = fov;
    }

    @Override
    protected void paintComponent(Graphics g1) {
        fps++;
        if (System.currentTimeMillis() - time > 1000) {
            time = System.currentTimeMillis();
            System.out.println("FPS: " + (fps));
            fps = 0;
        }

        Graphics2D g = (Graphics2D) g1;

        if (!modifiers.isEmpty()) {
            for (int i = 0; i < modifiers.size(); i++) {
                Modifier modifier = modifiers.get(i);
                if (modifier instanceof ModifierTranslateMovements) {
                    posZ = ((ModifierTranslateMovements)modifier).getPosZ();
                }
                modifier.modify(g);
                modifier.modify(g, getWidth(), getHeight());
            }
        }

        for (Element element : elementList) {
            element.modify(g, getWidth(), getHeight());
            element.draw(g, getWidth(), getHeight(), 0, 0);
            element.drawChilds(g, getWidth(), getHeight());
            element.modifyInvert(g, getWidth(), getHeight());
        }
    }

    public void update() {
        if (!modifiers.isEmpty()) {
            for (Modifier modifier : modifiers) {
                modifier.update(keyHandler);
            }
        }
        if (!elementList.isEmpty()) {
            for (Element element : elementList) {
                element.update(keyHandler, mouseHandler, mouseMotionHandler, mouseWheel);
            }
        }
    }

    public int elementCount() {
        int elements = elementList.size();
        for (Element element : elementList) {
            elements += element.elementCount();
        }
        return elements;
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }

}

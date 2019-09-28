package engine.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeyHandler implements KeyListener {

    private List<Character> lastChars = new ArrayList<>();
    private List<Character> currentChars = new ArrayList<>();

    public void update() {
        lastChars.clear();
        Collections.addAll(lastChars, currentChars.toArray(new Character[0]));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!currentChars.contains(e.getKeyChar())) {
            currentChars.add((Character) e.getKeyChar());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (currentChars.contains(e.getKeyChar())) {
            currentChars.remove((Character) e.getKeyChar());
        }
    }

    public boolean hasKeyDown() {
        return !currentChars.isEmpty();
    }

    public boolean hasKeyUp() {
        return currentChars.isEmpty();
    }

    public boolean isKeyDown(char c) {
        return currentChars.contains(c);
    }

    public boolean isKeyUp(char c) {
        return !currentChars.contains(c);
    }

    public boolean hasKeyTypedUp() {
        return !lastChars.isEmpty() && currentChars.isEmpty();
    }

    public boolean hasKeyTypedDown() {
        return lastChars.isEmpty() && !currentChars.isEmpty();
    }

    public boolean isKeyTypedUp(char c) {
        return lastChars.contains(c) && !currentChars.contains(c);
    }

    public boolean isKeyTypedDown(char c) {
        return !lastChars.contains(c) && currentChars.contains(c);
    }

    @Override
    public String toString() {
        return "KeyHandler{" +
                "lastChars=" + lastChars +
                ", currentChars=" + currentChars +
                '}';
    }
}

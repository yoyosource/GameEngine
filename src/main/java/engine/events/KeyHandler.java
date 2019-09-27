package engine.events;

import engine.Renderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyHandler implements KeyListener {

    private List<Character> lastChars = new ArrayList<>();
    private List<Character> currentChars = new ArrayList<>();

    public void update() {
        lastChars.clear();
        lastChars.addAll(currentChars);
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

    public boolean isKeyDown(char c) {
        return currentChars.contains(c);
    }

    public boolean isKeyUp(char c) {
        return !currentChars.contains(c);
    }

    public boolean isKeyTypedUp(char c) {
        return lastChars.contains(c) && !currentChars.contains(c);
    }

    public boolean isKeyTypedDown(char c) {
        return !lastChars.contains(c) && currentChars.contains(c);
    }

}

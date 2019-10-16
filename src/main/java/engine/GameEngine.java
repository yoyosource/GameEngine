package engine;

import engine.events.KeyHandler;
import engine.events.MouseHandler;
import engine.events.MouseMotionHandler;
import engine.events.MouseWheel;
import engine.uiBehavior.Action;
import engine.uiBehavior.Modifier;
import engine.ui.Element;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GameEngine implements Runnable {

    private String title;
    private int width;
    private int height;

    private int minWidth;
    private int minHeight;

    private Renderer renderer;
    private JFrame frame;

    private boolean rendering = true;

    private double updateTime = 0;

    private KeyHandler keyHandler;
    private MouseMotionHandler mouseMotionHandler;
    private MouseHandler mouseHandler;
    private MouseWheel mouseWheel;

    private Action gameTickFunction = new Action();

    public GameEngine(String title, int width, int height) {
        this.title = title;

        this.width = width;
        this.height = height;

        createWindow();
    }

    private void createWindow() {
        keyHandler = new KeyHandler();
        mouseMotionHandler = new MouseMotionHandler();
        mouseHandler = new MouseHandler(mouseMotionHandler);
        mouseWheel = new MouseWheel();
        renderer = new Renderer(keyHandler, mouseHandler, mouseMotionHandler, mouseWheel);

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setFocusTraversalKeysEnabled(false);

        System.out.println(frame.getWidth() + " " + frame.getHeight());
        System.out.println(frame.getContentPane().getWidth() + " " + frame.getContentPane().getHeight());
        renderer.setBounds(0, 0, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
        frame.setContentPane(renderer);
        frame.validate();

        frame.addKeyListener(keyHandler);
        frame.addMouseMotionListener(mouseMotionHandler);
        frame.addMouseListener(mouseHandler);
        frame.addMouseWheelListener(mouseWheel);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (frame.getWidth() < minWidth) {
                    frame.setSize(minWidth, frame.getHeight());
                }
                if (frame.getHeight() < minHeight) {
                    frame.setSize(frame.getWidth(), minHeight);
                }
            }
        });

        renderer.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int height = e.getComponent().getHeight();
                int width = e.getComponent().getWidth();

                renderer.setBounds(0, 0, width, height);
                renderer.repaint();
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                super.windowClosing(e);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                dispose();
                super.windowClosed(e);
            }
        });

        render();
    }

    private void render() {
        Thread t = new Thread(this);
        t.setName("GameEngine-" + frame.getTitle());
        t.start();
    }

    @Override
    public void run() {
        long t = System.currentTimeMillis();
        while (rendering) {
            if (System.currentTimeMillis() - t > updateTime) {
                t = System.currentTimeMillis();
                gameTickFunction.run();
                renderer.update();
                keyHandler.update();
                mouseWheel.update();
            }
            renderer.repaint();
            /*
            try {
                Thread.sleep(0, 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }*/
        }
    }

    public void dispose() {
        rendering = false;
    }

    public void addElement(Element element)  {
        renderer.addElement(element);
        renderer.repaint();
    }

    public void setSize(int width, int height) {
        frame.setSize(width, height);
        if (frame.getWidth() < minWidth) {
            frame.setSize(minWidth, frame.getHeight());
        }
        if (frame.getHeight() < minHeight) {
            frame.setSize(frame.getWidth(), minHeight);
        }
    }

    public void setMinSize(int minWidth, int minHeight) {
        this.minWidth = minWidth;
        this.minHeight = minHeight;
        if (frame.getWidth() < minWidth) {
            frame.setSize(minWidth, frame.getHeight());
        }
        if (frame.getHeight() < minHeight) {
            frame.setSize(frame.getWidth(), minHeight);
        }
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
        if (frame.getWidth() < minWidth) {
            frame.setSize(minWidth, frame.getHeight());
        }
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
        if (frame.getHeight() < minHeight) {
            frame.setSize(frame.getWidth(), minHeight);
        }
    }

    public void addModifier(Modifier modifier) {
        renderer.addModifier(modifier);
    }

    public void setUpdateTime(int i) {
        if (i < 0) {
            updateTime = 1000.0 / 120;
        }
        if (i == 0) {
            updateTime = 0;
            return;
        }
        updateTime = 1000.0 / i;
    }

    public void setUpdateTime(double i) {
        if (i < 0) {
            updateTime = 1000.0 / 120;
        }
        updateTime = i;
    }

    public int elementCount() {
        return renderer.elementCount();
    }

    public void setResizable(boolean resizable) {
        frame.setResizable(resizable);
    }

    public void setGameTickFunction(Action gameTickFunction) {
        this.gameTickFunction = gameTickFunction;
    }

    public void setIconImage(URL url) {
        try {
            BufferedImage image = ImageIO.read(url);
            frame.setIconImage(image);
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public void setIconImage(String s) {
        URL resource = GameEngine.class.getResource(s);
        setIconImage(resource);
    }

}

package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;



/**
 * Created by Kira on 06.01.2017.
 */
public class Field extends JPanel
{
    private EventListener eventListener;
    private View view;

    public Field(View view) {

        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(0,0,view.getWidth(),view.getHeight());
        g.fillRect(0,0,view.getWidth(),view.getHeight());
        Set<GameObject> gameObjects = view.getGameObjects().getAll();
        for (GameObject object: gameObjects) {
            object.draw(g);
        }
    }

    public class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT: {
                    eventListener.move(Direction.LEFT);
                    break;
                }
                case KeyEvent.VK_RIGHT: {
                    eventListener.move(Direction.RIGHT);
                    break;
                }
                case KeyEvent.VK_UP: {
                    eventListener.move(Direction.UP);
                    break;
                }
                case KeyEvent.VK_DOWN: {
                    eventListener.move(Direction.DOWN);
                    break;
                }
                case KeyEvent.VK_R: {
                    eventListener.restart();
                    break;
                }
            }
        }
    }
}

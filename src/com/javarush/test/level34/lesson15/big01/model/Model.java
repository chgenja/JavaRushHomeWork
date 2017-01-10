package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

/**
 * Created by Kira on 06.01.2017.
 */
public class Model {

    public static final int FIELD_SELL_SIZE = 20;

    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("D:\\NotGames\\java\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt"));

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void restartLevel(int level) {
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restartLevel(currentLevel);
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall: gameObjects.getWalls()) {
            if (gameObject.isCollision(wall,direction))
                return true;
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction) {
        for (Box box: gameObjects.getBoxes()) {
            if ((gameObjects.getPlayer().isCollision(box,direction)) && (checkWallCollision(box,direction)))
                return true;
            for (Box box2: gameObjects.getBoxes()) {
                if ((gameObjects.getPlayer().isCollision(box,direction)) && (box.isCollision(box2,direction)) && (box != box2))
                    return true;
            }
            if (gameObjects.getPlayer().isCollision(box,direction)) {
                switch (direction) {
                    case DOWN:
                        box.move(0,FIELD_SELL_SIZE);
                        break;
                    case UP:
                        box.move(0,-FIELD_SELL_SIZE);
                        break;
                    case LEFT:
                        box.move(-FIELD_SELL_SIZE,0);
                        break;
                    case RIGHT:
                        box.move(FIELD_SELL_SIZE,0);
                        break;
                }
                return false;
            }
        }
        return false;
    }

    public void checkCompletion() {
        int boxesInHomes = 0;
        for (Box box : gameObjects.getBoxes())
            for (Home home : gameObjects.getHomes())
                if ((box.getX()==home.getX()) && (box.getY()==home.getY()))
                    boxesInHomes++;
        if (boxesInHomes == gameObjects.getHomes().size())
            eventListener.levelCompleted(currentLevel);
    }

    public void move(Direction direction) {
        if (checkWallCollision(gameObjects.getPlayer(), direction))
            return;
        if (checkBoxCollision(direction))
            return;
        switch (direction) {
            case DOWN:
                gameObjects.getPlayer().move(0, FIELD_SELL_SIZE);
                break;
            case UP:
                gameObjects.getPlayer().move(0, -FIELD_SELL_SIZE);
                break;
            case LEFT:
                gameObjects.getPlayer().move(-FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                gameObjects.getPlayer().move(FIELD_SELL_SIZE, 0);
                break;
        }
        checkCompletion();
    }


}

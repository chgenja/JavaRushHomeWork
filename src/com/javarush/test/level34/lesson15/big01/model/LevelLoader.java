package com.javarush.test.level34.lesson15.big01.model;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Kira on 07.01.2017.
 */
public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        int currentLevel = (level == 60) ? 60 : level % 60;
        Set<Wall> walls = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Player player = null;
        int cellSize = Model.FIELD_SELL_SIZE;
        int x0 = cellSize / 2;
        int y0 = cellSize / 2;
        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
            String currentLine = "";
            while (!currentLine.equals("Maze: " + currentLevel)) {
                currentLine = reader.readLine();
            }
            currentLine = reader.readLine();
            currentLine = reader.readLine();
            int sizeX = Integer.parseInt(currentLine.substring(8));
            currentLine = reader.readLine();
            int sizeY = Integer.parseInt(currentLine.substring(8));
            currentLine = reader.readLine();
            currentLine = reader.readLine();
            currentLine = reader.readLine();
            for (int i = 0; i < sizeY; i++) {
                currentLine = reader.readLine();
                for (int j = 0; j < sizeX; j++) {
                    char c = currentLine.charAt(j);
                    switch (c) {
                        case 'X':
                            walls.add(new Wall(x0 + j*cellSize, y0 + i*cellSize));
                            break;
                        case '*':
                            boxes.add(new Box(x0 + j*cellSize, y0 + i*cellSize));
                            break;
                        case '.':
                            homes.add(new Home(x0 + j*cellSize, y0 + i*cellSize));
                            break;
                        case '&':
                            boxes.add(new Box(x0 + j*cellSize, y0 + i*cellSize));
                            homes.add(new Home(x0 + j*cellSize, y0 + i*cellSize));
                            break;
                        case '@':
                            player = new Player(x0 + j*cellSize, y0 + i*cellSize);
                            break;
                    }
                }
            }
            return new GameObjects(walls, boxes, homes, player);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

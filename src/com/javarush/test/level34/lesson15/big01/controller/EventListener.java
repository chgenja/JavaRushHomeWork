package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;

/**
 * Created by Kira on 07.01.2017.
 */
public interface EventListener {
    public void move(Direction direction);
    public void restart();
    public void startNextLevel();
    public void levelCompleted(int level);
}

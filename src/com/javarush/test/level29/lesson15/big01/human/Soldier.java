package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Kira on 30.09.2016.
 */
public class Soldier extends Human
{

    protected int course;

    public Soldier(String name, int age)
    {
        super(name, age);
    }

    public void live() {
        fight();
    }

    public void fight() {
    }

    public int getCourse() {
        return course;
    }
}

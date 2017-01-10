package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Kira on 23.01.2016.
 */
public class Plane implements Flyable
{
    public int passengers_count;

    public Plane(int i)
    {
        this.passengers_count = i;
    }

    public void fly() {}
}

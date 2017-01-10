package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Kira on 07.06.2016.
 */
public class Horse
{
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void move()
    {
        double turnDistance = getSpeed()*Math.random();
        setDistance(getDistance() + turnDistance);
    }

    public void print()
    {
        String printed = "";
        StringBuilder stringBuilder = new StringBuilder(printed);
        for (int i = 0; i < (int) getDistance(); i++)
            stringBuilder.append(".");
        stringBuilder.append(getName());
        System.out.println(stringBuilder);
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }
}

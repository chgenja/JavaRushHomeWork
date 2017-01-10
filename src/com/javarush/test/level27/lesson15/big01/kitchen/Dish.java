package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Kira on 03.12.2016.
 */
public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Dish dish : Dish.values()) {
            if (!first)
                sb.append(", ");
            else
                first = false;
            sb.append(dish.toString());
        }
        return sb.toString();
    }
}

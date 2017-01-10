package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Kira on 03.12.2016.
 */
public class Order {
    private Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "";
        else {
            return "Your order: " + dishes.toString() + " of Tablet{number=" + tablet.getNumber() + "}";
        }
    }

    public int getTotalCookingTime() {
        int result = 0;
        for (Dish dish : dishes)
            result += dish.getDuration();
        return result;
    }

    public boolean isEmpty() {
        if (dishes == null || dishes.isEmpty())
            return true;
        return false;
    }
}

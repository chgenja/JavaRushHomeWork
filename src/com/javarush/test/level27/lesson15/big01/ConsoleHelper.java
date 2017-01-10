package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kira on 03.12.2016.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage("Select dishes: " + Dish.allDishesToString() + ". Write \"exit\" for exit");
        List<Dish> result = new ArrayList<>();
        String dish;
        while (!(dish = readString()).equals("exit")) {
            try {
                result.add(Dish.valueOf(dish));
            } catch (IllegalArgumentException e) {
                writeMessage(dish + " is not detected");
            }
        }
        return result;
    }
}

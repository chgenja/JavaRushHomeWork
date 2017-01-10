package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

/**
 * Created by Kira on 03.12.2016.
 */
public class Restaurant {
    public static void main(String[] args) {
        Cook cook = new Cook("Amigo");
        Waitor waitor = new Waitor();
        cook.addObserver(waitor);
        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        tablet.createOrder();


    }
}

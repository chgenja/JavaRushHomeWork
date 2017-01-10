package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Kira on 07.06.2016.
 */
public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();

    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void move()
    {
        for (Horse horse : getHorses())
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : getHorses())
        {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public void run() throws InterruptedException
    {
        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public Horse getWinner()
    {
        Horse winner = null;
        double maxDistance = 0;
        for (Horse horse : getHorses())
        {
            if (horse.getDistance() > maxDistance)
                maxDistance = horse.getDistance();
        }
        for (Horse horse : getHorses())
        {
            if (horse.getDistance() == maxDistance)
            {
                winner = horse;
                break;
            }
        }
        return winner;
    }

    public void printWinner()
    {
        Horse winner = getWinner();
        System.out.println("Winner is " + winner.getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        ArrayList<Horse> current = game.getHorses();
        current.add(new Horse("Twilight",3,0));
        current.add(new Horse("Applejack",3,0));
        current.add(new Horse("Rainbow",3,0));
        game.run();
        game.printWinner();
    }


}

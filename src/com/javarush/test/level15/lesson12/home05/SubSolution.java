package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Kira on 19.01.2016.
 */
public class SubSolution extends Solution
{
    public SubSolution()
    {
        super();
    }

    public SubSolution(boolean b)
    {
        super(b);
    }

    public SubSolution(boolean b, String s)
    {
        super(b, s);
    }

    protected SubSolution(String s)
    {
        super(s);
    }

    protected SubSolution(String s, boolean b)
    {
        super(s, b);
    }

    protected SubSolution(Integer i, String s)
    {
        super(i, s);
    }

    SubSolution(Integer i)
    {
        super(i);
    }

    SubSolution(String s, Integer i)
    {
        super(s, i);
    }

    SubSolution(String s, Integer i, boolean b)
    {
        super(s, i, b);
    }

    private SubSolution(Integer i, boolean b, String s)
    {
        super(s);
    }

    private SubSolution(boolean b, String s, Integer i)
    {
        super(s,b);
    }
    private SubSolution(boolean b, Integer i, String s)
    {
        super(i,s);
    }



}

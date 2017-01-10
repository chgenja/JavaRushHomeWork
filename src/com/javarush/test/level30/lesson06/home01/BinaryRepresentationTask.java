package com.javarush.test.level30.lesson06.home01;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Kira on 06.10.2016.
 */
public class BinaryRepresentationTask extends RecursiveTask
{
    private int i;

    public BinaryRepresentationTask(int i)
    {
        this.i = i;
    }

    @Override
    protected String compute()
    {
        int a = i % 2;
        int b = i / 2;
        String result = String.valueOf(a);

        if (b > 0)
        {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            return task.join() + new BinaryRepresentationTask(a).compute();
        }

        return result;
    }
}

package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Kira on 31.08.2016.
 */
public class MyThread extends Thread
{
    private static AtomicInteger count = new AtomicInteger(0);

    public MyThread()
    {
        count.incrementAndGet();
        if (count.get() > 10)
            count.set(count.get()-10);
        this.setPriority(count.get());
    }

    public MyThread(Runnable target)
    {
        count.incrementAndGet();
        if (count.get() > 10)
            count.set(count.get()-10);
        this.setPriority(count.get());
    }

    public MyThread(ThreadGroup group, Runnable target)
    {

        super(group, target);
        count.incrementAndGet();
        if (count.get() > 10)
            count.set(count.get()-10);
        this.setPriority(Math.min(count.get(),group.getMaxPriority()));

    }

    public MyThread(String name)
    {
        super(name);
        count.incrementAndGet();
        if (count.get() > 10)
            count.set(count.get()-10);
        this.setPriority(count.get());
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        count.incrementAndGet();
        if (count.get() > 10)
            count.set(count.get()-10);
        this.setPriority(Math.min(count.get(),group.getMaxPriority()));
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        count.incrementAndGet();
        if (count.get() > 10)
            count.set(count.get()-10);
        this.setPriority(count.get());
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        count.incrementAndGet();
        if (count.get() > 10)
            count.set(count.get()-10);
        this.setPriority(Math.min(count.get(),group.getMaxPriority()));
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        count.incrementAndGet();
        if (count.get() > 10)
            count.set(count.get()-10);
        this.setPriority(Math.min(count.get(),group.getMaxPriority()));
    }
}

package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator
{
    String threadName;
    Thread thread;

    @Override
    public void run() {
    try{
        thread.sleep(0);

        while (!thread.isInterrupted())
        {
                System.out.println(threadName);
                thread.sleep(90);
            }

        } catch (InterruptedException e)
        {
        }
    }

    @Override
    public void start(String threadName)
    {
        this.threadName = threadName;
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();
    }

    @Override
    public void stop()
    {
        thread.interrupt();
    }
}

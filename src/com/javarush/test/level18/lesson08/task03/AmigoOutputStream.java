package com.javarush.test.level18.lesson08.task03;

import java.io.*;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "D:/NotGames/java/JavaRushHomeWork/src/com/javarush/test/level18/lesson08/task03/asd.txt";
    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream outputStream) throws FileNotFoundException
    {
        super(fileName);
        this.original = outputStream;
    }

    @Override
    public void write(int b) throws IOException
    {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        original.write(b, off, len);
    }

    @Override
    public FileChannel getChannel()
    {
        return original.getChannel();
    }

    @Override
    public void flush() throws IOException
    {
        original.flush();
    }

    @Override
    protected void finalize() throws IOException
    {
        super.finalize();
    }

    public static void main(String[] args) throws IOException
    {
        AmigoOutputStream a = new AmigoOutputStream(new FileOutputStream(fileName));
        a.close();
    }

    @Override
    public void close() throws IOException
    {
        flush();
        String s = "JavaRush © 2012-2013 All rights reserved.";
        byte[] endLine = s.getBytes();
        write(endLine);
        original.close();
    }
}


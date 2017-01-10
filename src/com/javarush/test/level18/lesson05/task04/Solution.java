package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename1 = reader.readLine();
            String filename2 = reader.readLine();
            reader.close();

            FileInputStream inputStream = new FileInputStream(filename1);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            byte[] buffer2 = new byte[buffer.length];
            for (int i = 0; i < buffer2.length; i++)
                buffer2[i] = buffer[buffer.length - 1 - i];
            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(filename2);
            outputStream.write(buffer2);
            outputStream.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

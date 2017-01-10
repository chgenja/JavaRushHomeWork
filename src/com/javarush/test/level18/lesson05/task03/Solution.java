package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
            String filename3 = reader.readLine();
            reader.close();

            FileInputStream inputStream = new FileInputStream(filename1);
            byte[] buffer = new byte[inputStream.available()];
            byte[] bufferFirst = new byte[buffer.length - buffer.length/2];
            byte[] bufferSecond = new byte[buffer.length/2];

            inputStream.read(buffer);
            inputStream.close();

            for (int i = 0; i < (buffer.length+1)/2; i++)
                bufferFirst[i] = buffer[i];
            for (int i = 0; i < buffer.length/2; i++)
                bufferSecond[i] = buffer[i+(buffer.length)/2];

            FileOutputStream outputStream = new FileOutputStream(filename2);
            outputStream.write(bufferFirst);
            outputStream.close();
            FileOutputStream outputStream1 = new FileOutputStream(filename3);
            outputStream1.write(bufferSecond);
            outputStream1.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

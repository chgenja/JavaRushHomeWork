package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(filename);
        boolean isStarted = false;
        int min = 0;
        while (inputStream.available() > 0)
        {
            if (isStarted == false)
            {
                min = inputStream.read();
                isStarted = true;
            }
            int data = inputStream.read();
            if (data < min)
                min = data;
        }
        System.out.println(min);
        inputStream.close();
    }
}

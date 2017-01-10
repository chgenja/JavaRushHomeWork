package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename1 = reader.readLine();
            String filename2 = reader.readLine();
            reader.close();
            File file = new File(filename1);

            char[] buffer = new char[(int) file.length()];
            FileReader inputStream = new FileReader(filename1);
            inputStream.read(buffer);
            inputStream.close();

            FileReader inputStream2 = new FileReader(filename2);
            FileWriter outputStream2 = new FileWriter(filename1);

            while (inputStream2.ready())
            {
                int data = inputStream2.read();
                outputStream2.write(data);
            }
            inputStream2.close();

            for (char c : buffer)
            {
                int data = (int) c;
                outputStream2.write(data);
            }
            outputStream2.close();



        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

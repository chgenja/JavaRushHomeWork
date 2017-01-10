package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        boolean even = false;
        FileReader filereader = new FileReader(filename1);
        FileWriter filewriter = new FileWriter(filename2);
        while (filereader.ready())
        {
            if (even == true)
            {
                int data = filereader.read();
                filewriter.write(data);
                even = false;
            } else
            {
                int data = filereader.read();
                even = true;
            }
        }
        filereader.close();
        filewriter.close();
    }
}

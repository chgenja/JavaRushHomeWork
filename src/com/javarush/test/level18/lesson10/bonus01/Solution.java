package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[1];
        String fileOutputName = args[2];

        if (args[0].equals("-e"))
            encript(fileName,fileOutputName);
        else if (args[0].equals("-d"))
            decript(fileName,fileOutputName);

    }

    public static void encript(String fileName, String fileOutputName) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutputName);
        while (inputStream.available()>0)
        {
            int data = inputStream.read();
            outputStream.write(data+1);
        }
        inputStream.close();
        outputStream.close();
    }
    public static void decript(String fileName, String fileOutputName) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutputName);
        while (inputStream.available()>0)
        {
            int data = inputStream.read();
            outputStream.write(data-1);
        }
        inputStream.close();
        outputStream.close();
    }


}

package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (!args[0].equals("-c"))
            return;

        String productName = args[1];
        String price = args[2];
        String quantity = args[3];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        Scanner scanner = new Scanner(new File(filename));
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine().substring(0,8));
        }
        String[] idsStr = lines.toArray(new String[0]);

        int[] ids = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++)
        {
            if (idsStr[i].indexOf(" ") != -1)
                ids[i] = Integer.parseInt(idsStr[i].substring(0,idsStr[i].indexOf(" ")));
            else
                ids[i] = Integer.parseInt(idsStr[i]);
        }


        int max = ids[0];
        for (int i = 1; i < ids.length; i++)
            if (ids[i] > max)
                max = ids[i];

        FileWriter writer = new FileWriter(filename,true);

        String newId = String.valueOf(max+1);
        int newIdLength = newId.length();

        writer.write(newId);
        for (int i = 0; i < (8 - newIdLength); i++)
        {
            writer.write(" ");
        }

        int productNameLength = productName.length();
        if (productNameLength > 30)
        {
            writer.write(productName.substring(0,30));
        } else
        {
            writer.write(productName);
            for (int i = 0; i < (30 - productNameLength); i++)
                writer.write(" ");
        }

        int priceNameLength = price.length();
        if (priceNameLength > 8)
        {
            writer.write(price.substring(0,8));
        } else
        {
            writer.write(price);
            for (int i = 0; i < (8 - priceNameLength); i++)
                writer.write(" ");
        }

        int quantityNameLength = quantity.length();
        if (quantityNameLength > 4)
        {
            writer.write(quantity.substring(0,4));
        } else
        {
            writer.write(quantity);
            for (int i = 0; i < (4 - quantityNameLength); i++)
                writer.write(" ");
        }

        writer.close();


        }
}

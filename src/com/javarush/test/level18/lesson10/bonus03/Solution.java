package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        if (args.length < 1)
            return;

        if (args[0].equals("-u"))
            update(filename,args[1],args[2],args[3],args[4]);
        else if (args[0].equals("-d"))
            delete(filename,args[1]);
        else return;
    }

    public static void update(String filename, String id, String productName, String price, String quantity) throws IOException
    {
        if (id.length() > 8)
            return;

        Scanner scanner = new Scanner(new File(filename), "UTF-8");
        List<String> rows = new ArrayList<>();
        while (scanner.hasNextLine())
        {
            rows.add(scanner.nextLine());
        }
        scanner.close();

        for (int i = 0; i < rows.size(); i++)
        {
            String currentRow = rows.get(i);
            String requiredId = id;
            String newRow = "";
            for (int j = 0; j < (8-id.length()); j++)
                requiredId += " ";
            if (currentRow.substring(0,8).equals(requiredId))
            {
                newRow = requiredId + productName;
                for (int k = 0; k < (30-productName.length()); k++)
                    newRow += " ";
                newRow += price;
                for (int k = 0; k < (8-price.length()); k++)
                    newRow += " ";
                newRow += quantity;
                for (int k = 0; k < (4-quantity.length()); k++)
                    newRow += " ";
                Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
                for (int j = 0; j < rows.size(); j++)
                {
                    if (i==j)
                        writer.write(newRow);
                    else
                        writer.write(rows.get(j));
                    writer.write(System.lineSeparator());
                }
                writer.close();
                break;
            }
        }
    }
    public static void delete(String filename, String id) throws IOException
    {
        if (id.length() > 8)
            return;

        Scanner scanner = new Scanner(new File(filename), "UTF-8");
        List<String> rows = new ArrayList<>();
        while (scanner.hasNextLine())
        {
            rows.add(scanner.nextLine());
        }
        scanner.close();
        int index = 0;
        for (int i = 0; i < rows.size(); i++)
        {
            String currentRow = rows.get(i);
            String requiredId = id;
            for (int j = 0; j < (8-id.length()); j++)
                requiredId += " ";
            if (currentRow.substring(0,8).equals(requiredId))
            {
                index = i;
                Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
                for (int j = 0; j < rows.size(); j++)
                {
                    if (index != j)
                    {
                        writer.write(rows.get(j));
                        writer.write(System.lineSeparator());
                    }
                }
                writer.close();
                break;
            }
        }
    }
}

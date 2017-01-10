package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();
            reader.close();
            File file = new File(filename);

            List<String> lines = new ArrayList<String>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();

            String id = args[0];
            int idLength = id.length();

            for (String line: lines)
            {
                if (line.substring(0,idLength).equals(id) && line.substring(idLength,idLength+1).equals(" "))
                {
                    System.out.println(line);
                    break;
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

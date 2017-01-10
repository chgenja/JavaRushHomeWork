package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String filename1 = reader.readLine();
            String filename2 = reader.readLine();

            File file1 = new File(filename1);
            File file2 = new File(filename2);
            Scanner scanner1 = new Scanner(file1);
            while (scanner1.hasNextLine())
            {
                String line = scanner1.nextLine();
                allLines.add(line);
            }
            scanner1.close();
            Scanner scanner2 = new Scanner(file2);
            while (scanner2.hasNextLine())
            {
                String line = scanner2.nextLine();
                forRemoveLines.add(line);
            }
            scanner2.close();
            new Solution().joinData();
        } catch (CorruptedDataException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {
        int remove_count = forRemoveLines.size();
        int allLines_removed_count = 0;
        for (String s : forRemoveLines)
        {
            if (allLines.contains(s))
                allLines_removed_count++;
        }
        if (remove_count == allLines_removed_count)
        {
            for (String s : forRemoveLines)
                allLines.remove(allLines.indexOf(s));
        } else
        {
            for (int i = 0; i < allLines.size(); i++)
                allLines.remove(i);
            throw new CorruptedDataException();
        }
    }
}

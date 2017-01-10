package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        BufferedReader file1reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename1),"UTF-8"));
        BufferedReader file2reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename2),"UTF-8"));

        List<String> file1strings = new ArrayList<>();
        List<String> file2strings = new ArrayList<>();

        while (file1reader.ready())
        {
            String s = file1reader.readLine();
            file1strings.add(s);
        }
        while (file2reader.ready())
        {
            String s = file2reader.readLine();
            file2strings.add(s);
        }

        int file1index = 0;
        int file2index = 0;

        while ((file1index < file1strings.size()) && (file2index < file2strings.size()))
        {
            if (file1strings.get(file1index).equals(file2strings.get(file2index)))
            {
                lines.add(new LineItem(Type.SAME,file1strings.get(file1index)));
                file1index++;
                file2index++;
            }
            else if (file2index != file2strings.size() - 1 && file1strings.get(file1index).equals(file2strings.get(file2index + 1)))
                {
                        lines.add(new LineItem(Type.ADDED, file2strings.get(file2index)));
                        lines.add(new LineItem(Type.SAME, file1strings.get(file1index)));
                        file1index++;
                        file2index++;
                        file2index++;
                }
            else if (file1index != file1strings.size() - 1 && file1strings.get(file1index+1).equals(file2strings.get(file2index)))
                {
                        lines.add(new LineItem(Type.REMOVED,file1strings.get(file1index)));
                        lines.add(new LineItem(Type.SAME,file1strings.get(file1index+1)));
                        file1index++;
                        file1index++;
                        file2index++;

                }
        }

        if (file1index < file1strings.size())
                lines.add(new LineItem(Type.REMOVED,file1strings.get(file1strings.size()-1)));
        else if (file2index < file2strings.size())
                lines.add(new LineItem(Type.ADDED,file2strings.get(file2strings.size()-1)));


        file1reader.close();
        file2reader.close();


    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

package com.javarush.test.level19.lesson10.home03;

import javax.swing.text.DateFormatter;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),"UTF-8"));

        while (reader.ready())
        {
            String[] words = reader.readLine().split(" ");
            int length = words.length;

            String name = "";
            for (int i = 0; i < length-3; i++)
            {
                if (i != 0)
                    name = name + " ";
                name = name + words[i];
            }

            String dateStr = words[length-3] + " " + words[length-2] + " " + words[length-1];
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            Date date = format.parse(dateStr);


            PEOPLE.add(new Person(name, date));
        }
        reader.close();
    }

}

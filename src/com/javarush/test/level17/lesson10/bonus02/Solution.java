package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {

    public volatile static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        //start here - начни тут
        if (args[0].equals("-c"))
            create(args);
        else if (args[0].equals("-u"))
            update(args);
        else if (args[0].equals("-d"))
            delete(args);
        else if (args[0].equals("-i"))
            info(args);
        else return;
    }

    public static synchronized void create(String[] args)
    {
        int count = args.length;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 1; i < count; i+=3)
            {
                String name = args[i];
                String sex = args[i+1];
                String bd = args[i+2];
                try
                {
                    if (sex.equals("м"))
                        allPeople.add(Person.createMale(name, format.parse(bd)));
                    else if (sex.equals("ж"))
                        allPeople.add(Person.createFemale(name, format.parse(bd)));
                }   catch (ParseException e)
                {
                    e.printStackTrace();
                }
                System.out.println(allPeople.size()-1);

            }
    }

    public static synchronized void update(String[] args)
        {
            int count = args.length;

            for (int i = 1; i < count; i += 4)
            {
                int id = Integer.parseInt(args[i]);
                String name = args[i + 1];
                String sex = args[i + 2];
                String bd = args[i + 3];
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                allPeople.get(id).setName(name);
                if (sex.equals("м"))
                    allPeople.get(id).setSex(Sex.MALE);
                else if (sex.equals("ж"))
                    allPeople.get(id).setSex(Sex.FEMALE);
                try
                {
                    allPeople.get(id).setBirthDay(format.parse(bd));
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
            }
        }

    public static synchronized void delete(String[] args)
        {
            int count = args.length;

            for (int i = 1; i < count; i++)
            {
                int id = Integer.parseInt(args[i]);
                allPeople.get(id).setBirthDay(null);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
            }
        }
    public static void info(String[]args)
     {
         int count = args.length;

         for (int i = 1; i < count; i++)
            {
                int id = Integer.parseInt(args[i]);
                Person person = allPeople.get(id);
                String name = person.getName();
                String sex = "";
                if (person.getSex().equals(Sex.MALE))
                    sex = "м";
                else if (person.getSex().equals(Sex.FEMALE))
                    sex = "ж";

                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                String bd = format.format(allPeople.get(id).getBirthDay());
                System.out.println(name + " " + sex + " " + bd);
            }


     }
}

package com.javarush.test.level17.lesson10.bonus01;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args.length == 0)
            return;
        try {
        if (args[0].equals("-c"))
        {
            String name = args[1];
            String sex = args[2];
            String bd = args[3];
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Person new_one = null;
            try
            {
                if (sex.equals("м"))
                    new_one = Person.createMale(name, format.parse(bd));
                else if (sex.equals("ж"))
                    new_one = Person.createFemale(name, format.parse(bd));
                else throw new IOException("Wrong Data");
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            allPeople.add(new_one);
            System.out.println(allPeople.indexOf(new_one));
        } else
        {
            if (args[0].equals("-u"))
            {
                int id = Integer.parseInt(args[1]);
                String name = args[2];
                String sex = args[3];
                String bd = args[4];
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Person new_one = null;
                allPeople.get(id).setName(name);
                try
                {
                    if (sex.equals("м"))
                        allPeople.get(id).setSex(Sex.MALE);
                    else if (sex.equals("ж"))
                        allPeople.get(id).setSex(Sex.FEMALE);
                    else throw new IOException("Wrong data");
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                allPeople.get(id).setBirthDay(format.parse(bd));
            } else if (args[0].equals("-d"))
            {
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setBirthDay(null);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
            } else if (args[0].equals("-i"))
            {
                int id = Integer.parseInt(args[1]);
                SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String name = allPeople.get(id).getName();
                String sex = "";
                if (String.valueOf(allPeople.get(id).getSex()).equals("MALE"))
                    sex = "м";
                else if (String.valueOf(allPeople.get(id).getSex()).equals("FEMALE"))
                    sex = "ж";
                String bd = format.format(allPeople.get(id).getBirthDay());

                System.out.println(name + " " + sex + " " + bd);
            } else
            {
                return;
            }
        }
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}

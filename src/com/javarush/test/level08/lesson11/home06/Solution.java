package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grandpa1 = new Human();
        grandpa1.name = "Grandpa1";
        grandpa1.sex = true;
        grandpa1.age = 70;
        Human grandpa2 = new Human();
        grandpa2.name = "grandpa2";
        grandpa2.sex = true;
        grandpa2.age = 70;
        Human grandma1 = new Human();
        grandma1.name = "grandma1";
        grandma1.sex = false;
        grandma1.age = 70;
        Human grandma2 = new Human();
        grandma2.name = "grandma2";
        grandma2.sex = false;
        grandma2.age = 70;
        Human father = new Human();
        father.name = "father";
        father.sex = true;
        father.age = 70;
        Human mother = new Human();
        mother.name = "mother";
        mother.sex = false;
        mother.age = 70;
        Human child1 = new Human();
        child1.name = "child1";
        child1.sex = true;
        child1.age = 70;
        Human child2 = new Human();
        child2.name = "child2";
        child2.sex = false;
        child2.age = 70;
        Human child3 = new Human();
        child3.name = "child3";
        child3.sex = true;
        child3.age = 70;
        grandpa1.children.add(father);
        grandpa2.children.add(mother);
        grandma1.children.add(father);
        grandma2.children.add(mother);
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);

        System.out.println(grandpa1.toString());
        System.out.println(grandpa2.toString());
        System.out.println(grandma1.toString());
        System.out.println(grandma2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}

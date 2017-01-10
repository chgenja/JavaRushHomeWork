package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        int age = 0;
        boolean sex = true;
        String name = "";
        String surname = "";
        Human father = null;
        Human mother = null;

        public Human()
        {
            System.out.println("No parameters");
        }

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex, String surname)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.surname = name;
        }

        public Human(String name, int age, boolean sex, String surname, Human father, Human mother)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.surname = name;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, int age, String surname, Human father, Human mother)
        {
            this.name = name;
            this.age = age;
            this.surname = name;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, int age, boolean sex, String surname, Human father)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.surname = name;
            this.father = father;
        }

        public Human(String name, int age, String surname, Human mother)
        {
            this.name = name;
            this.age = age;
            this.surname = name;
            this.mother = mother;
        }

        public Human(String name, int age, boolean sex, Human father, Human mother)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }


    }
}

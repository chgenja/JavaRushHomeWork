package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human dedushka1 = new Human();
        dedushka1.name = "Вася";
        dedushka1.sex = true;
        dedushka1.age = 66;
        Human dedushka2 = new Human();
        dedushka2.name = "Петя";
        dedushka2.sex = true;
        dedushka2.age = 67;
        Human babushka1 = new Human();
        babushka1.name = "Тамара";
        babushka1.sex = false;
        babushka1.age = 65;
        Human babushka2 = new Human();
        babushka2.name = "Зоя";
        babushka2.sex = false;
        babushka2.age = 64;
        Human papa = new Human();
        papa.name = "Виктор";
        papa.sex = true;
        papa.age = 44;
        papa.father = dedushka1;
        papa.mother = babushka1;
        Human mama = new Human();
        mama.name = "Таня";
        mama.sex = false;
        mama.age = 42;
        mama.father = dedushka2;
        mama.mother = babushka2;
        Human sin1 = new Human();
        sin1.name = "Петя";
        sin1.sex = true;
        sin1.age = 15;
        sin1.father = papa;
        sin1.mother = mama;
        Human sin2 = new Human();
        sin2.name = "Коля";
        sin2.sex = true;
        sin2.age = 8;
        sin2.father = papa;
        sin2.mother = mama;
        Human doch = new Human();
        doch.name = "Маша";
        doch.sex = false;
        doch.age = 1;
        doch.father = papa;
        doch.mother = mama;

        System.out.println(dedushka1.toString());
        System.out.println(dedushka2.toString());
        System.out.println(babushka1.toString());
        System.out.println(babushka2.toString());
        System.out.println(papa.toString());
        System.out.println(mama.toString());
        System.out.println(sin1.toString());
        System.out.println(sin2.toString());
        System.out.println(doch.toString());
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        Human father;
        Human mother;


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}

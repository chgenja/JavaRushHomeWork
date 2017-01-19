package com.javarush.test.level35.lesson10.bonus01;

import com.javarush.test.level35.lesson06.home01.ClassForGenerics;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals("D:\\NotGames\\java\\JavaRushHomeWork\\out\\production\\JavaRushHomeWork\\com\\javarush\\test\\level35\\lesson10\\bonus01\\data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<? extends Animal> result = new HashSet<>();
        String filePath = "";
        if (pathToAnimals.charAt(pathToAnimals.length()-1) != '/')
            filePath = pathToAnimals+"/";
        File file = new File(filePath);
        File[] listOfFiles = file.listFiles();
        List<String> compiledClassFiles = new ArrayList<>();
        for (int i = 0; i < listOfFiles.length; i++) {
            File f = listOfFiles[i];
            if (f.getName().endsWith(".class"))
                compiledClassFiles.add(f.getPath());
        }


        try {
            for (int i = 0; i < compiledClassFiles.size(); i++) {
                String filename = compiledClassFiles.get(i);
                Class currentClass = Class.forName(filename);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}

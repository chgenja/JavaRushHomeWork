package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        double median;
        if (array.length %2 == 0)
            median = ( array[array.length / 2 - 1] + array[(array.length)/2 ] ) / 2;
        else
            median = array[array.length / 2];
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++)
            result[i] = Math.abs(array[i] - median);

        Arrays.sort(result);
        Integer[] resultation = new Integer[array.length];

        for (int i = 0; i < result.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                if (array[j] != null)
                    if (result[i] == Math.abs(array[j]-median))
                    {
                        resultation[i] = array[j];
                        array[j] = null;
                        break;
                    }
            }
        }
        array = resultation;
        //implement logic here
        return array;
    }

    public static void main(String[] args)
    {
        Integer[] array = {3, 4, 7, 6, 5, 2, 1, 11, 5, 48, 49, 56, 92, 94};
        Integer[] result = sort(array);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }
}

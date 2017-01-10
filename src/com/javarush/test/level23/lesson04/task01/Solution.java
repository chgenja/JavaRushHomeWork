package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution = new Solution();
        solution.innerClasses[0] = solution.new InnerClass();
        solution.innerClasses[1] = solution.new InnerClass();
        Solution solution2 = new Solution();
        solution2.innerClasses[0] = solution.new InnerClass();
        solution2.innerClasses[1] = solution.new InnerClass();
        Solution[] result = {solution, solution2};
        return result;
    }
}

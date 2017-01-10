package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution()
    {}
    public Solution(boolean b)
    {}
    public Solution(boolean b, String s)
    {}
    protected Solution(String s)
    { this(0,true,s); }
    protected Solution(String s, boolean b)
    { this(b,s,0); }
    protected Solution(Integer i, String s)
    { this(false,i,s); }
    Solution(Integer i)
    {}
    Solution(String s, Integer i)
    {}
    Solution(String s, Integer i, boolean b)
    {}
    private Solution(Integer i, boolean b, String s)
    {}
    private Solution(boolean b, String s, Integer i)
    {}
    private Solution(boolean b, Integer i, String s)
    {}

}


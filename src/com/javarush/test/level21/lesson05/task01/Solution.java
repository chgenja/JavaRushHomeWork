package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        return !(last != null ? !last.equals(solution.last) : solution.last != null);

    }

    @Override
    public int hashCode()
    {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution("Hello","people");
        Solution s2 = null;
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

    }
}

package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student s = null;
        for (Student student : getStudents())
        {
            if (student.getAverageGrade()==averageGrade)
                s = student;
        }
        return s;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student s = null;
        double maxAverageGrade = 0;
        for (Student student : students)
        {
            if (student.getAverageGrade() > maxAverageGrade)
            {
                maxAverageGrade = student.getAverageGrade();
                s = student;
            }
        }
        return s;
    }

    public Student getStudentWithMinAverageGrade()
    {
        Student s = null;
        double minAverageGrade = Double.MAX_VALUE;
        for (Student student : students)
        {
            if (student.getAverageGrade() < minAverageGrade)
            {
                minAverageGrade = student.getAverageGrade();
                s = student;
            }
        }
        return s;
    }

    public void expel(Student student)
    {
        students.remove(student);
    }

}

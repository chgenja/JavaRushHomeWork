package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by Kira on 02.09.2016.
 */
public interface Strategy
{
    public List<Vacancy> getVacancies(String searchString);

}

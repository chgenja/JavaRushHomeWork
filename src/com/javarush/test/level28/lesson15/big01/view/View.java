package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by Kira on 04.09.2016.
 */
public interface View
{
    void update(List<Vacancy> vacancies);
    void setController(Controller controller);



}

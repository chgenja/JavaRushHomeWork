package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.view.View;

/**
 * Created by Kira on 02.09.2016.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        HtmlView view = new HtmlView();
        Provider[] providers = {new Provider(new HHStrategy())};
        Model model = new Model(view,providers);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}

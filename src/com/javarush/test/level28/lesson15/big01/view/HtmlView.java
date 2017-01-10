package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

/**
 * Created by Kira on 04.09.2016.
 */
public class HtmlView implements View
{
    Controller controller;
    //private final String filePath = "src\\com\\javarush\\test\\level28\\lesson15\\big01\\view\\vacancies.html";
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.','/') + "/vacancies.html";


    @Override
    public void update(List<Vacancy> vacancies)
    {
        updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod()
    {
        controller.onCitySelect("Moscow");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancyList)
    {
        String content = null;
        try
        {
            Document doc = getDocument();
            Element template = doc.select(".template").first();

            Element pattern = template.clone();
            pattern.removeAttr("style");
            pattern.removeClass("template");
            doc.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy : vacancyList)
            {
                Element vacancyElement = pattern.clone();
                vacancyElement.getElementsByClass("city").first().text(vacancy.getCity());
                vacancyElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                vacancyElement.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element link = vacancyElement.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());
                template.before(vacancyElement.outerHtml());
            }
            content = doc.html();

        } catch (IOException e)
        {
            content = "Some exception occured";
            e.printStackTrace();
        }
        return content;

    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private void updateFile(String name)
    {
        try
        {
            PrintWriter writer = new PrintWriter(filePath);
            writer.print(name);
            writer.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }


}

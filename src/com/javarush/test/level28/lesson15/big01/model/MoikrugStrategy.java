package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kira on 25.09.2016.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=english teacher+%s";
    //"http://javarush.ru/testdata/big28data2.html";
    private static final String referrer = "https://moikrug.ru/vacancies?q=english teacher+Dnepropetrovsk";
    private static final String userAgent = "Mozilla/5.0";
    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        int nom = 0;
        try
        {
            while (true)
            {
                Document doc = getDocument(searchString, nom++); // получили документ и увеличили счетчик
                Elements elements = doc.getElementsByClass("job");
                if (elements.size() == 0) break; // если нет вакансий прекращаю
                for (Element element : elements)
                {
                    // title
                    Element titleElement = element.getElementsByClass("title").first();
                    String title = titleElement.text();
                    // salary
                    Element salaryElement = element.getElementsByClass("salary").first();
                    String salary = "";
                    if (salaryElement != null)
                    {
                        salary = salaryElement.text();
                    }
                    // city
                    Element cityElement = element.getElementsByClass("location").first();
                    String city = "";
                    if (cityElement != null)
                    {
                        city = cityElement.text();
                    }
                    // company
                    String companyName = element.getElementsByClass("company_name").first().text();
                    // site
                    String siteName = "https://moikrug.ru";
                    // url
                    String url = "https://moikrug.ru" + element.getElementsByClass("inner").select("a").attr("href");
                    // add vacancy to the list
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancies.add(vacancy);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return vacancies;
    }


    protected Document getDocument(String searchString, int nom) throws IOException
    {
        String url = String.format(URL_FORMAT, nom, searchString);//searchString город, 1 это страница
        Document doc = Jsoup.connect(url).userAgent(userAgent).referrer(referrer).get();
        return doc;

    }
}


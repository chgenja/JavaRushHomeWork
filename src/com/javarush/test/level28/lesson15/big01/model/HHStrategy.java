package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kira on 02.09.2016.
 */
public class HHStrategy implements Strategy
{

    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=english teacher+%s&page=%d";
    private static final String referrer = "http://hh.ru/search/vacancy?text=english teacher";
    private static final String userAgent = "Mozilla/5.0";
    private static final int timeout = 5 * 1000;
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
                Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
                if (elements.size() == 0) break; // если нет вакансий прекращаю
                for (Element element : elements)
                {
                    // title
                    Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    String title = titleElement.text();
                    // salary
                    Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    String salary = "";
                    if (salaryElement != null)
                    {
                        salary = salaryElement.text();
                    }
                    // city
                    Element cityElement = element.select("[data-qa=vacancy-serp__vacancy-address]").first();
                    String city = "";
                    if (cityElement != null)
                    {
                        city = cityElement.text();
                    }
                    // company

                    Element companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first();
                    String company = "";
                    if (companyName != null)
                    {
                        company = companyName.text();
                    }
                    // site
                    String siteName = "http://hh.ru/";
                    // url
                    String url = titleElement.attr("href");
                    // add vacancy to the list
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(company);
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


    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, searchString, page);//searchString город, 1 это страница
        Document doc = Jsoup.connect(url).userAgent(userAgent).referrer(referrer).timeout(timeout).get();
        return doc;

    }
}

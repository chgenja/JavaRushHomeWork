package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kira on 12.12.2016.
 */

@XmlType(name = "shop")
@XmlRootElement
public class Shop {

    @XmlElementWrapper(name = "goods")
    @XmlElement
    public List<String> names;

    @XmlElement(name = "count")
    public int count;

    @XmlElement(name = "profit")
    public double profit;

    @XmlElement(name = "secretData")
    public List<String> secretData;

    public Shop() {
        names = new ArrayList<>();
        secretData = new ArrayList<>();
    }

}

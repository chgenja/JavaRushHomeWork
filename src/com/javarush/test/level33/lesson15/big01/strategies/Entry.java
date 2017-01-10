package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Kira on 31.12.2016.
 */
public class Entry implements Serializable {
    int hash;
    Long key;
    String value;
    Entry next;

    public Entry(int hash, Long key, String value, Entry next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final Long getKey() {
        return key;
    }

    public final String getValue() {
        return value;
    }

    public final int hashCode()  {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}

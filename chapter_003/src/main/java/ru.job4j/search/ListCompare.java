package ru.job4j.search;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {

        return o1.compareTo(o2);
    }

}

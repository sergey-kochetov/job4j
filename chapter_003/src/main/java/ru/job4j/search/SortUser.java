package ru.job4j.search;


import java.util.*;

import static java.lang.System.out;

public class SortUser {

    public Set<UserComparable> sort(List<UserComparable> list) {
        return new TreeSet<>(list);

    }

    public List<UserComparable> sortNameLength (List<UserComparable> list) {
        List<UserComparable> result =  list;
        result.sort((o1, o2) -> Integer.compare(o1.getName().length(), o2.getName().length()));
        return result;

    }

    public static void main(String[] args) {
        SortUser su = new SortUser();
        List<UserComparable> list = new ArrayList<>();
        list.add(new UserComparable("name1", 20));
        list.add(new UserComparable("name002", 21));
        list.add(new UserComparable("nam1", 15));
        list.add(new UserComparable("name001", 5));
        List<UserComparable> ts = su.sortNameLength(list);
         ts.forEach(out::println);
    }
}

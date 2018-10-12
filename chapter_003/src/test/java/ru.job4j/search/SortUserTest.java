package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenUser4addOnListAndSortedReturnFirstUser() {
        SortUser sortUser = new SortUser();
        List<UserComparable> list = new ArrayList<>();
        list.add(new UserComparable("name1", 20));
        list.add(new UserComparable("name2", 21));
        list.add(new UserComparable("name1", 15));
        list.add(new UserComparable("name1", 5));

        TreeSet<UserComparable> ts = (TreeSet<UserComparable>) sortUser.sort(list);
        UserComparable result = ts.first();
        UserComparable expect = new UserComparable("name1", 5);

        assertThat(result, is(expect));



    }
}

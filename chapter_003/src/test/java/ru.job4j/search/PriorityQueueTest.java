package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {

    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }


    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0 ,0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2on2ArrayThenList4() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when3onListArrayThenList() {
        ConvertList2Array list2Array = new ConvertList2Array();
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{1, 2});
        input.add(new int[]{3, 4, 5, 6, 7});
        input.add(new int[]{8});
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8
        );
        List<Integer> result = list2Array.convert(input);
        assertThat(result, is(expect));
    }

}

package ru.job4j.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int[][] result = null;
        Iterator<Integer> it = list.iterator();
        if (rows > 0) {
            int width = list.size() % rows == 0 ? list.size()/rows : list.size()/rows + 1;
            result = new int[width][rows];
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < rows; j++) {
                    if (it.hasNext()) {
                        result[i][j] = it.next();
                    } else {
                        result[i][j] = 0;
                    }
                }
            }
        }
        return result;
    }

    public List<Integer> toList (int[][] arrays){
        List<Integer> result = new ArrayList<>();
        for (int[] array : arrays) {
            for (int i : array) {
                result.add(i);
            }
        }
        return result;
    }
}

package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * MatrixIterator.
 */
public class MatrixIterator implements Iterator {
    /**
     * array.
     */
    private final int[][] array;
    /**
     * indexX.
     */
    private int indexX = 0;
    /**
     * indexY.
     */
    private int indexY = 0;

    /**
     * Constructor.
     * @param array - arr
     */
    public MatrixIterator(int[][] array) {
        this.array = array;
    }

    /**
     * hasNext.
     * @return exist next element.
     */
    @Override
    public boolean hasNext() {
        boolean result = true;
        if (indexY == array[indexX].length) {
            indexX++;
            indexY = 0;
        }
        if (indexX == array.length) {
            result = false;
        }

        return result;
    }

    /**
     * Next.
     * @return next int
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[indexX][indexY++];
    }

    /**
     * remove.
     */
    @Override
    public void remove() {
        throw  new UnsupportedOperationException();
    }

    /**
     * forEachRemaining.
     * @param action - a
     */
    @Override
    public void forEachRemaining(Consumer action) {
        throw  new UnsupportedOperationException();
    }
}

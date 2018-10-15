package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * EvenNumbersIterator.
 */
public class EvenNumbersIterator implements Iterator {
    /**
     * array.
     */
    private final int[] array;
    /**
     * index.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param ints - array
     */
    public EvenNumbersIterator(final int[] ints) {
        this.array = ints;
    }

    /**
     * hasNext.
     * @return - even numbers
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (array.length == index) {
            return false;
        }
        if (array[index]%2 ==0) {
            result = true;
        } else {
            index++;
            result = hasNext();
        }
        return  result;

    }

    /**
     * next.
     * @return next even numbers
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[index++];
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

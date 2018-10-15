package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Converter.
 */
public class Converter {
    /**
     * convert.
     * @param it - more Iterator
     * @return - iterator
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            /**
             * currentIterator.
             */
            private Iterator<Integer> currentIterator = it.next();

            /**
             * hasNext
             * @return - next element exsist
             */
            @Override
            public boolean hasNext() {

                return currentIterator.hasNext() || it.hasNext();
            }

            /**
             * next.
             * @return - next element
             */
            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                if (!currentIterator.hasNext()) {
                    currentIterator = it.next();
                }
                return currentIterator.next();
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

        };
    }
}

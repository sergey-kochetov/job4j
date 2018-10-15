package ru.job4j.generic;

import java.util.*;
import java.util.function.Consumer;

/**
 * SimpleArray.
 * @param <T> - obj
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * simpleArrays.
     */
    private Object[] simpleArrays;
    /**
     * index.
     */
    private int index;

    /**
     * Constructor.
     * @param capacity - capasity for array.
     */
    public SimpleArray(final int capacity) {
        this.simpleArrays = new Object[capacity];
        this.index = 0;
    }

    /**
     * add.
     * @param model - obj
     */
    public void add(T model) {
        Objects.requireNonNull(model);
        if (!sizeValid()) {
            throw new IndexOutOfBoundsException();
        }
        simpleArrays[this.index++] = model;
    }

    /**
     * set
     * @param index - i
     * @param model - obj
     */
    public  void set(int index, T model) {
        Objects.requireNonNull(model);
        if (!sizeValid(index)) {
            throw new IndexOutOfBoundsException();
        }
        this.simpleArrays[index] = model;
    }

    /**
     * delete.
     * @param removeIndx - remove index
     * @return result
     */
    public boolean delete(int removeIndx) {
        if (!sizeValid(removeIndx)) {
            return false;
        }
        this.simpleArrays[removeIndx] = null;
        System.arraycopy(this.simpleArrays, removeIndx + 1, this.simpleArrays, removeIndx, size() - removeIndx -1);
        this.index--;
        return true;
    }

    /**
     * get.
     * @param index - i
     * @return obj
     */
    public T get(int index) {
        return (T) simpleArrays[index];
    }

    /**
     * size.
     * @return length array
     */
    public int size() {
        return this.index;
    }

    /**
     * Valid data.
     * @param length - length
     * @return result
     */
    private boolean sizeValid(int length) {
        return this.index > length && sizeValid();
    }

    /**
     * Valid data.
     * @return result
     */
    private boolean sizeValid() {
        return simpleArrays.length < index;
    }

    /**
     * iterator.
     * @return - it
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * position.
             */
            private int position = 0;

            /**
             * hasNext.
             * @return result
             */
            @Override
            public boolean hasNext() {
                return position < simpleArrays.length;
            }

            /**
             * next.
             * @return next obj
             */
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) simpleArrays[position++];
            }
        };
    }

    /**
     * forEach.
     * @param action - a
     */
    @Override
    public void forEach(Consumer<? super T> action) {
        throw new UnsupportedOperationException();
    }

    /**
     * spliterator.
     * @return - s
     */
    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException();
    }

}

package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * MatrixIteratorTest.
 */
public class MatrixIteratorTest {
    /**
     * Test a two-dimensional array of the correct form.
     * If iterator take array {{1, 2}, {3, 4}} should method next return {1, 2, 3, 4}.
     */
    @Test
    public void whenTakeArrayShouldMethodNextThenMethodNextReturnElementArray() {
        final MatrixIterator it = new MatrixIterator(new int[][]{{1, 2},{3, 4}});

        final int[] expectedArray = new int[]{1, 2, 3, 4};
        final int[] result = new int[4];
        int count = 0;
        while (it.hasNext()){
            result[count++] = it.next();
        }
        assertThat(expectedArray, is(result));
    }
    /**
     * Test a two-dimensional array is not the correct form.
     * If iterator take array {{1}, {2, 3, 4}} should method next return {1, 2, 3, 4}.
     */
    @Test
    public void whenTakeArrayShouldMethodNextThenMethodNextReturnElementArray2() {
        final MatrixIterator it = new MatrixIterator(new int[][]{{1}, {2, 3, 4}});

        final int[] expectedArray = new int[]{1, 2, 3, 4};
        final int[] result = new int[4];
        int count = 0;
        while (it.hasNext()){
            result[count++] = it.next();
        }
        assertThat(expectedArray, is(result));
    }

    /**
     * MatrixIterator.
     */
    private MatrixIterator it;

    /**
     * Before.
     */
    @Before
    public void setUp(){
        it = new MatrixIterator(new int[][]{{1}, {3, 4}, {7}});
    }

    /**
     * test 3.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation () {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    /**
     * test 4.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder () {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    /**
     * test 5.
     */
    @Test
    public void hasNextNextSequentialInvocation () {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
    }

}
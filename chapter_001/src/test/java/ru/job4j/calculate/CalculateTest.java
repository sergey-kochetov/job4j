package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test.
 *
 * @author Sergey Kochetov
 * @version $Id$
 * @since 0.1
 */
public class CalculateTest {
    /**
     * Test echo.
     */
    @Test
    public void whenTakeNameThenOneEchoPlusName() {
        String input = "Text";
        String expect = "Echo : Text";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }

}
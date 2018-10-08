package ru.job4j.calculate;
/**
 * calculate.
 */
public class Calculate {

    /**
     *  echo.
     * @param input - input.
     * @return result.
     */
    String echo(final String input) {
        return String.format("Echo : %s", input);
    }


    /**
     *  funk.
     * @param a - a.
     * @param b - b.
     */
    public static void funk(Integer a, int[] b) {
        b[0] = b[0] * 2;
        a = b[0] + 5;
    }

    /**
     * Main.
     * @param args - args.
     */
    public static void main(String[] args) {
        int bird = 10;
        int[] tiger = {7};

        Calculate.funk(bird, tiger);
        System.out.println("bird = " + bird);
        System.out.println("tigr = " + tiger[0]);

    }
}
package ru.job4j.tictactoe;

import java.util.function.Predicate;

/**
 * Logic3T.
 */
public class Logic3T {
    /**
     * Figure3T arrays.
     */
    private final Figure3T[][] table;

    /**
     * Constructor.
     * @param table - Figure3T arrays.
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * found winner X.
     * @return - winner found X.
     */
    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 2, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 2, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkX, Tictactoe.SIZE - 1, 0, -1, 1);
    }

    /**
     * found winner O.
     * @return - winner found O.
     */
    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 2, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 2, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkO, Tictactoe.SIZE - 1, 0, -1, 1);
    }

    /**
     * Gap.
     * @return - true.
     */
    public boolean hasGap() {
        return true;
    }

    /**
     * Hard.
     * @param predicate - predicate.
     * @param startX - start x.
     * @param startY - start y.
     * @param deltaX - delta x.
     * @param deltaY - delta y.
     * @return - true or false.
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }
}

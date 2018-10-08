package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;

/**
 * Figure3T.
 */
public class Figure3T extends Rectangle {
    /**
     * markX.
     */
    private boolean markX;
    /**
     * markY.
     */
    private boolean markO;

    /**
     * Constructor.
     */
    public Figure3T() {
        this.markX = false;
        this.markO = false;
    }

    /**
     * Constructor.
     * @param markX - markX.
     */
    public Figure3T(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**
     *  take.
     * @param markX - markX.
     */
    public  void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**
     *  has.
     * @return - has X.
     */
    public boolean hasMarkX() {
        return this.markX;
    }
    /**
     *  has.
     * @return - has O.
     */
    public boolean hasMarkO() {
        return this.markO;
    }
}

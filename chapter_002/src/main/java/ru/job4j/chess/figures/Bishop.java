package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;

import java.util.Arrays;
import java.util.List;

/**
 * Bishop.
 */
public class Bishop extends Figure {
    /**
     * Constructor.
     *
     * @param position - p
     */
    public Bishop(Cell position) {
        super(position);
    }
    /**
     * Way.
     *
     * @param src - source
     * @param dst - destiny
     * @return array cells
     */
    @Override
    public List<Cell> way(Cell src, Cell dst) {
        return Arrays.asList(new Cell[0]);
    }

    /**
     * Copy Bishop.
     *
     * @param dest - cell
     * @return new figure
     */
    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}

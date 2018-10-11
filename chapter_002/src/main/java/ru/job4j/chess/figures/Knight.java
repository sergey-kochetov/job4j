package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;

import java.util.Arrays;
import java.util.List;

public class Knight extends Figure {
    /**
     * Constructor.
     *
     * @param position - p
     */
    public Knight(Cell position) {
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
     * Copy King.
     *
     * @param dest - cell
     * @return new figure
     */
    @Override
    public Figure copy(Cell dest) {
        return new Knight(dest);
    }
}

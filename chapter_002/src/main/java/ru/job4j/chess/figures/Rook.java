package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;

import java.util.Arrays;
import java.util.List;

public class Rook extends Figure {
    /**
     * Constructor.
     *
     * @param position - p
     */
    public Rook(Cell position) {
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
     * Copy the figure that stands on the cell.
     *
     * @param dest - cell
     * @return new figure
     */
    @Override
    public Figure copy(Cell dest) {
        return new Rook(dest);
    }
}

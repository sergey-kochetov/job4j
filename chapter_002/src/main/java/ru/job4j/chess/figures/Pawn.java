package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;

import java.util.Arrays;
import java.util.List;

/**
 * Pawn.
 */
public class Pawn extends Figure {
    /**
     * Constructor.
     *
     * @param position - p
     */
    public Pawn(Cell position) {
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
        if (src.x == dst.x && (dst.y - src.y) == 1) {

        }
        return Arrays.asList(new Cell[0]);
    }

    /**
     * Copy Pawn.
     *
     * @param dest - cell
     * @return new figure
     */
    @Override
    public Figure copy(Cell dest) {
        return new Pawn(dest);
    }
}

package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;

import java.util.List;

/**
 * Abstract figure.
 */
public abstract class Figure {
    /**
     * position figure.
     */
    Cell position;

    /**
     * Getter.
     * @return cell
     */
    public Cell position() {
        return position;
    }

    /**
     * Constructor.
     * @param position - p
     */
    public Figure(Cell position) {
        this.position = position;
    }
    /**
     * Way.
     * @param src - source
     * @param dst - destiny
     * @return array cells
     */
    public abstract List<Cell> way(Cell src, Cell dst);

    /**
     * Icon.
     * @return *.png
     */
    public String icon() {
        return String.format("%s.png", this.getClass().getSimpleName());
    }

    /**
     * Copy the figure that stands on the cell.
     * @param dest - cell
     * @return new figure
     */
    public abstract Figure copy(Cell dest);
}

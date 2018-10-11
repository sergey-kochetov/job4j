package ru.job4j.chess;

import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figures.Figure;

import java.util.ArrayList;
import java.util.List;

public class Logic {
    private final List<Figure> figures = new ArrayList<>(33);
    private int index = 0;

    public void add(Figure figure) {
        this.figures.add(figure);
    }

    public boolean move(Cell source, Cell dest)  throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            List<Cell> steps = this.figures.get(index).way(source, dest);
            if (steps.size() > 0 && steps.get(steps.size() - 1).equals(dest)) {
                rst = true;
                this.figures.add(this.figures.get(index).copy(dest));
                this.figures.remove(index);
            }
        }
        return rst;
    }

    public void clean() {
        this.figures.clear();
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.size(); index++) {
            if (this.figures.get(index) != null && this.figures.get(index).position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}

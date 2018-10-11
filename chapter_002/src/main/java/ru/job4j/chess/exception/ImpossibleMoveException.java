package ru.job4j.chess.exception;

/**
 * ImpossibleMoveException.
 */
public class ImpossibleMoveException extends Exception {
    /**
     * constructor.
     * @param message - msg
     */
    public ImpossibleMoveException(String message) {
        super(message);
    }
}

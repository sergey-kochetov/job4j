package ru.job4j.tracker;

/**
 * Interface Input.
 */
public interface Input {
    /**
     * Ask.
     * @param question - question.
     * @return - answer string.
     */
    String ask(String question);

    /**
     * Ask.
     * @param question - question
     * @param range - our range
     * @return - numeric
     */
    int ask(String question, int[] range);
}

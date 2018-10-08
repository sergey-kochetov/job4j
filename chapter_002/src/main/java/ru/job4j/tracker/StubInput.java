package ru.job4j.tracker;

/**
 * StubInput.
 */
public class StubInput implements Input {
    /**
     * answers.
     */
    private String[] answers;
    /**
     * position.
     */
    private int position;

    /**
     * Constructor.
     * @param answers - answer.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
        this.position = 0;

    }

    /**
     * Ask.
     * @param question - question.
     * @return - answer.
     */
    @Override
    public String ask(String question) {
        return null;
    }
}

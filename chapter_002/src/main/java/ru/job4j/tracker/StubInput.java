package ru.job4j.tracker;

/**
 * StubInput.
 */
public class StubInput implements Input {
    /**
     * answers.
     */
    private final String[] value;
    /**
     * position.
     */
    private int position;

    /**
     * StubInput.
     * @param value - value.
     */
    public StubInput(String[] value) {
        this.value = value;
        this.position = 0;

    }

    /**
     * Ask.
     * @param question - question.
     * @return - answer.
     */
    @Override
    public String ask(String question) {
        return this.value[position++];
    }
}

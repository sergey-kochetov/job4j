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

    /**
     * Ask.
     *
     * @param question - question
     * @param range    - our range
     * @return - numeric
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range");
        }
        return key;
    }
}

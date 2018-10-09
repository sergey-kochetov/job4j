package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Console input.
 */
public class ConsoleInput implements Input {
    /**
     * Scanner.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     *  Ask.
     * @param question - question.
     * @return - answer.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
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

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
}

package ru.job4j.tracker;

/**
 * ValidateInput.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * valid ask.
     * @param question - question
     * @param range    - our range
     * @return answer
     */
    public  int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException ex) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}

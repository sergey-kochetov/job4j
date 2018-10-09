package ru.job4j.tracker;
/**
 * Starter.
 */
public class StartUI {
    /**
     * Valid range.
     */
    private int[] ranges = new int[] {0, 1, 2, 3, 4, 5, 6};
    /** flag. */
    private boolean exit = false;
    /** input. */
    private final Input input;
    /** Application Store. */
    private final Tracker tracker;
    /**
     * Constructor.
     * @param input - input data.
     * @param tracker - tracker.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Main.
     * @param args - args.
     */
    public static void main(String[] args) {

        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
    /**
     * fillActions starter.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        boolean isExit = true;
        menu.fillActions();
        do {
            if (!(this.input instanceof StubInput)) {
                menu.show();
            }
            int key = input.ask("Select: ", ranges);
            if (key != 6) {
                menu.select(key);
            } else {
                isExit = false;
            }
        } while (isExit);
    }
}

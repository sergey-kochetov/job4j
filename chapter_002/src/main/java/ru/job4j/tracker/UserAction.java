package ru.job4j.tracker;

/**
 * UserAction.
 */
public interface UserAction {
    /**
     *  Key user.
     * @return key
     */
    int key();

    /**
     *  Execute.
     * @param input -io
     * @param tracker - tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     *  Info.
     * @return info for user
     */
    String info();


}

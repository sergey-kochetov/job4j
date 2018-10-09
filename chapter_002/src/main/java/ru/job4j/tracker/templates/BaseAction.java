package ru.job4j.tracker.templates;

import ru.job4j.tracker.UserAction;

/**
 * BaseAction.
 */
public abstract class BaseAction implements UserAction {
    /** key. */
   private final int key;
   /** name. */
   private final String name;

    /**
     * Construcor.
     * @param key - key
     * @param name - name
     */
    protected BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Key user.
     *
     * @return key
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Info.
     *
     * @return info for user
     */
    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }
}

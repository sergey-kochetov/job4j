package ru.job4j.tracker;

import ru.job4j.tracker.templates.BaseAction;

/**
 * Menu Tracker.
 */
public class MenuTracker {
    /**
     * Input interaface.
     */
    private Input input;
    /**
     * Tracker.
     */
    private Tracker tracker;
    /**
     * Actions user.
     */
    private UserAction[] actions = new UserAction[7];

    /**
     * Constructor.
     * @param input - input
     * @param tracker - tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Init.
     */
    public void fillActions() {
        this.actions[0] = new AddItem(0, "Add item.");
        this.actions[1] = new ShowItem(1, "Show item.");
        this.actions[2] = new EditeItem(2, "Edite item.");
        this.actions[3] = new DeleteItem(3, "Delete item.");
        this.actions[4] = new FindItemById(4, "Find item by id.");
        this.actions[5] = new FindItemByName(5, "Find item by name.");
        this.actions[6] = new ExitProgram(6, "Exit.");
    }

    /**
     * Select.
     * @param key -k
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * show menu.
     */
    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    /**
     * AddItem.
     */
    private class AddItem extends BaseAction {
        /**
         * Construcor.
         *
         * @param key  - key
         * @param name - name
         */
        protected AddItem(int key, String name) {
            super(key, name);
        }

        /**
         * execute.
         * @param input -io
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            Item item = new Item(name, desc);
            tracker.add(item);
        }

    }

    /**
     * Show item.
     */
    private class ShowItem extends BaseAction {
        /**
         * Construcor.
         *
         * @param key  - key
         * @param name - name
         */
        protected ShowItem(int key, String name) {
            super(key, name);
        }
        /**
         * execute.
         * @param input -io
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
           for (Item item : tracker.getAll()) {
               System.out.println(String.format("%s. %s", item.getId(), item.getName()));
           }
        }
    }

    /**
     * Edite item.
     */
    private class EditeItem extends BaseAction {
        /**
         * Construcor.
         *
         * @param key  - key
         * @param name - name
         */
        protected EditeItem(int key, String name) {
            super(key, name);
        }
        /**
         * execute.
         * @param input -io
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Edite item by id...");
            Item item = tracker.findById(id);
            if (item != null) {
                String name = input.ask("Please, enter the task's name: ");
                String desc = input.ask("Please, enter the task's desc: ");
                Item newItem = new Item(name, desc, id);
                tracker.replace(id, newItem);
            }
        }
    }

    /**
     * Delete item.
     */
    private class DeleteItem extends BaseAction {
        /**
         * Construcor.
         *
         * @param key  - key
         * @param name - name
         */
        protected DeleteItem(int key, String name) {
            super(key, name);
        }
        /**
         * Execute.
         *
         * @param input   -io
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Delete item by id...");
            tracker.delete(id);
        }
    }

    /**
     * Find item by id.
     */
    private class FindItemById extends BaseAction {
        /**
         * Construcor.
         *
         * @param key  - key
         * @param name - name
         */
        protected FindItemById(int key, String name) {
            super(key, name);
        }

        /**
         * Execute.
         *
         * @param input   -io
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name for search...");
            Item item = tracker.findById(name);
        }
    }

    /**
     * Find item by name.
     */
    private class FindItemByName extends BaseAction {
        /**
         * Construcor.
         *
         * @param key  - key
         * @param name - name
         */
        protected FindItemByName(int key, String name) {
            super(key, name);
        }

        /**
         * Execute.
         *
         * @param input   -io
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name for search...");
            Item[] items = tracker.findByName(name);
        }
    }

    /**
     * Exit program.
     */
    private class ExitProgram extends BaseAction {
        /**
         * Construcor.
         *
         * @param key  - key
         * @param name - name
         */
        protected ExitProgram(int key, String name) {
            super(key, name);
        }

        /**
         * Execute.
         *
         * @param input   -io
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }

}

package ru.job4j.tracker;
/**
 * Starter.
 */
public class StartUI {
    /** flag. */
    private boolean exit = false;
    /** Константа меню для добавления новой заявки.*/
    private static final String ADD = "0";
    /** Show all items.*/
    private static final String SHOW = "1";
    /** Edit item.*/
    private static final String EDIT = "2";
    /** Delete item. */
    private static final String DEL = "3";
    /** Find item by Id. */
    private static final String FIND_BY_ID = "4";
    /** Find items by name. */
    private static final String FIND_BY_NAME = "5";
    /** Константа для выхода из цикла.*/
    private static final String EXIT = "6";
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
//        Input input = new StubInput(new String[] {"create stub task"});
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }

    /**
     * init starter.
     */
    private void init() {
        do {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню :");
            switch (answer) {
                case ADD:
                    this.createItems();
                    break;
                case SHOW:
                    this.showItems();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DEL:
                    this.delItem();
                    break;
                case FIND_BY_ID:
                    this.findByIdItem();
                    break;
                case FIND_BY_NAME:
                    this.findByNameItem();
                    break;
                case EXIT:
                    this.exitProgram();
                    break;
                 default:
            }

        } while (!exit);

    }

    /**
     * findByNameItem.
     */
    private void findByNameItem() {
        String name = this.input.ask("Enter name for search...");
        Item[] items = tracker.findByName(name);
        if (items == null) {
            return;
        }
        for (Item i : items) {
            System.out.println(i);
        }
    }

    /**
     * findByIdItem.
     */
    private void findByIdItem() {
        String name = this.input.ask("Enter name for search...");
        Item item = tracker.findById(name);
        if (item == null) {
            return;
        }
        System.out.println(item);
    }
    /**
     * delItem.
     */
    private void delItem() {
        String id = this.input.ask("Delete item by id...");
        if (tracker.delete(id)) {
            System.out.println("---delete complite---");
        } else {
            System.out.println("---delete  not complite---");
        }

    }

    /**
     * editItem.
     */
    private void editItem() {
        String id = this.input.ask("Edite item by id...");
        Item item = tracker.findById(id);
        //System.out.println(item);
        if (item != null) {

            String name = this.input.ask("Введите имя заявки :");
            String desc = this.input.ask("Введите описание заявки :");
            Item newItem = new Item(name, desc, id);
            tracker.replace(id, newItem);
        } else {
            System.out.println("id not found...");
        }
    }

    /**
     * showItems.
     */
    private void showItems() {
        System.out.println("Show all items...");

        for (Item i :  tracker.findAll()) {
            System.out.println(i);
        }

    }

    /**
     * exitProgram.
     */
    private void exitProgram() {
        this.exit = true;
    }

    /**
     * createItems.
     */
    private void createItems() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * showMenu.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item:");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
}

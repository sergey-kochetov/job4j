package ru.job4j.tracker;

/**
 * Class Item.
 */
public class Item {
    /**
     *  Item id.
     */
    private String id;
    /**
     * Item name.
     */
    private String name;
    /**
     * Item description.
     */
    private String desc;
    /**
     * Item data created.
     */
    private long created;
    /**
     * Array comments.
     */
    private String[] comments;

    /**
     * Default constructor.
     */
    public Item() {

    }

    /**
     *  Constructor for Test.
     * @param name - name.
     * @param desc - description.
     * @param id - Item id.
     */
    public Item(String name, String desc, long id) {
        this.name = name;
        this.desc = desc;
        this.id = String.valueOf(id);
    }

    /**
     *  Getter.
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter.
     * @param id - Item id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter.
     * @return item name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter.
     * @param name - item name.
     */
    public void setName(String name) {
        this.name = name;
    }
}

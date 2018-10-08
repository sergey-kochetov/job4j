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
    public Item(String name, String desc, String id) {
        this.name = name;
        this.desc = desc;
        this.id = id;
    }

    /**
     *  Constructor.
     * @param name - name.
     * @param desc - description.
     */
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
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

//    /**
//     *  String result.
//     * @return item.
//     */
//    @Override
//    public String toString() {
//        return "Item{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", desc='" + desc + '\'' +
//                ", created=" + created +
//                ", comments=" + Arrays.toString(comments) +
//                '}';
//    }
}

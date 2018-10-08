package ru.job4j.tracker;

import java.time.temporal.ValueRange;

/**
 * Class Tracker.
 */
public class Tracker {
    /**
     * Arrys item.
     */
    private Item[] items;
    /**
     * position of array.
     */
    private int position;

    /**
     * Default constructor.
     */
    public Tracker() {
        this.items = new Item[100];
        this.position = 0;
    }

    /**
     * Getter.
     * @return - array item.
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * Add item to array.
     * @param item - item.
     * @return - created item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items[position++] = item;
        return item;
    }

    /**
     *  Replace item by id.
     * @param id - id item.
     * @param item - new item for replace.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * Delete item by id.
     * @param id - id item.
     */
    public void delete(String id) {
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                removeElement(this.items, i);
                break;
            }
        }

    }

    /**
     * Find all item NotNull.
     * @return - array item.
     */
    public Item[] findAll() {
        Item[] result = new Item[position];
        System.arraycopy(this.items, 0, result, 0, position - 1);
        return result;
    }

    /**
     * Find all name for array items.
     * @param name -  name.
     * @return - items array.
     */
    public Item[] findByName(String name) {
        int count = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (items[i].getName().equals(name)) {
                count++;
            }
        }
        Item[] result = new Item[count];
        count = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (items[i].getName().equals(name)) {
                result[count] = this.items[i];
                count++;
            }
        }
        return result;
    }

    /**
     *  Find item by id.
     * @param id - item id.
     * @return - index found.
     */
    public Item findById(String id) {
        for (Item i : this.items) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    /**
     * Generated id.
     * @return - new id.
     */
    private String generateId() {
        long minId = 1L;
        long maxId = 1_000_000L;
        // long generatedId = minId + (long) (Math.random() * (maxId - minId));
        // Реализовать метод генерации.
        return ValueRange.of(minId, maxId).toString();
    }

    /**
     * Remove element for array item.
     * @param arr - array item.
     * @param removedIdx - index for removing.
     */
    private void removeElement(Item[] arr, int removedIdx) {
        System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    }
}

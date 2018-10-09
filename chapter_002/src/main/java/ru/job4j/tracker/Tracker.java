package ru.job4j.tracker;

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
     *  delete.
     * @param id - id.
     * @return checked.
     */
    public boolean delete(String id) {
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                removeElement(this.items, i);
                return true;
            }
        }
        return false;

    }
    /**
     * Find all item NotNull.
     * @return - array item.
     */
    public Item[] getAll() {
        Item[] result = new Item[position];
        System.arraycopy(this.items, 0, result, 0, position);
        return result;
    }

    /**
     * Find all name for array items.
     * @param name -  name.
     * @return - items array.
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[position];
        int count = 0;
        for (int i = 0; i < this.getAll().length; i++) {
            if (items[i].getName().equals(name)) {
                result[count] = items[i];
                count++;
            }
        }
        if (count > 0) {
            System.arraycopy(result, 0, result, 0, position);
        } else {
            return null;
        }

        return result;
    }

    /**
     *  Find item by id.
     * @param id - item id.
     * @return - index found.
     */
    public Item findById(String id) {
        for (Item i : this.getAll()) {
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
        long generatedId = minId + (long) (Math.random() * (maxId - minId));
        // Реализовать метод генерации.
        return String.valueOf(generatedId);
    }

    /**
     * Remove element for array item.
     * @param arr - array item.
     * @param removedIdx - index for removing.
     */
    private void removeElement(Item[] arr, int removedIdx) {
        System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
        position--;
    }
}

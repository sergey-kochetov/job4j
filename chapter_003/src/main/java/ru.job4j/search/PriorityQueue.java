package ru.job4j.search;

import java.util.Collections;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {

        tasks.add(task);

        Collections.sort(this.tasks, (o1, o2) -> o1.getPriority() - o2.getPriority());

    }

    public Task take() {
        return this.tasks.poll();
    }
}

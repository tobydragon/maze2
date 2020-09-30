package edu.ithaca.dragon.datastructures.queue;

public interface Queue {
    
    /**
     * puts an item onto the "end" of the queue
     */
    void enqueue(String item);

    /**
     * removes an item from the "front" of the queue
     * @return the item removed
     */
    String dequeue();

    /**
     * @return true if the queue has no items, false otherwise
     */
    boolean isEmpty();
}

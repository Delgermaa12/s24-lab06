package edu.cmu.cs.cs214.rec04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SortedIntList -- a list that maintains its elements in sorted order.
 *
 * @author Nora Shoemaker
 */
public class SortedIntList implements IntegerList {
    private final List<Integer> list;

    /**
     * Constructs a new SortedIntList.
     */
    public SortedIntList() {
        list = new ArrayList<>();
    }

    /**
     * Adds the specified integer to the list, maintaining sorted order.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean add(int num) {
        list.add(num);
        Collections.sort(list); // Sort the list after adding the element
        return true;
    }

    /**
     * Adds all elements from the specified IntegerList to this list,
     * maintaining sorted order.
     *
     * @param integerList IntegerList containing elements to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean addAll(IntegerList integerList) {
        int initialSize = list.size();
        for (int i = 0; i < integerList.size(); i++) {
            list.add(integerList.get(i));
        }
        Collections.sort(list); // Sort the list after adding all elements
        return list.size() > initialSize;
    }

    /**
     * Returns the integer at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public int get(int index) {
        return list.get(index);
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param num an integer to be removed from the list, if present
     * @return true if an element was removed as a result of this call
     */
    @Override
    public boolean remove(int num) {
        return list.remove((Integer) num);
    }

    /**
     * Removes all elements in the specified IntegerList from this list.
     *
     * @param integerList IntegerList containing elements to be removed from this list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean removeAll(IntegerList integerList) {
        boolean changed = false;
        for (int i = 0; i < integerList.size(); i++) {
            changed |= list.remove((Integer) integerList.get(i));
        }
        return changed;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return list.size();
    }
}

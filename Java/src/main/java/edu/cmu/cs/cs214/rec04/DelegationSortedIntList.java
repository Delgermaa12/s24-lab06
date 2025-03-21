package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 */
public class DelegationSortedIntList implements IntegerList {
    // Private SortedIntList object for delegation
    private final SortedIntList sortedList;

    // Counter to keep track of the total number of added elements
    private int totalAdded;

    /**
     * Constructs a new DelegationSortedIntList.
     */
    public DelegationSortedIntList() {
        this.sortedList = new SortedIntList(); // Initialize the internal list
        this.totalAdded = 0; // Initialize the total added counter
    }

    /**
     * Adds the specified integer to the list and increments the totalAdded counter.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean add(int num) {
        boolean isAdded = sortedList.add(num);
        if (isAdded) {
            totalAdded++;
        }
        return isAdded;
    }

    /**
     * Adds all elements from the specified IntegerList to this list.
     * Increments the totalAdded counter by the number of elements successfully added.
     *
     * @param list IntegerList containing elements to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean addAll(IntegerList list) {
        int originalSize = sortedList.size();
        boolean isAdded = sortedList.addAll(list);
        if (isAdded) {
            totalAdded += sortedList.size() - originalSize;
        }
        return isAdded;
    }

    /**
     * Returns the integer at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public int get(int index) {
        return sortedList.get(index);
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param num an integer to be removed from the list, if present
     * @return true if an element was removed as a result of this call
     */
    @Override
    public boolean remove(int num) {
        return sortedList.remove(num);
    }

    /**
     * Removes all elements in the specified IntegerList from this list.
     *
     * @param list IntegerList containing elements to be removed from this list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean removeAll(IntegerList list) {
        return sortedList.removeAll(list);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return sortedList.size();
    }

    /**
     * Returns the total number of elements that were attempted to be added to the list.
     *
     * @return the total number of added elements
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}

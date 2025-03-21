package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 */
public class InheritanceSortedIntList extends SortedIntList {
    private int totalAdded; // Counter for total attempted additions

    /**
     * Constructs a new InheritanceSortedIntList.
     */
    public InheritanceSortedIntList() {
        super();
        totalAdded = 0;
    }

    /**
     * Overrides the add method to count the total number of additions.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean add(int num) {
        totalAdded++; // Increment the counter
        return super.add(num);
    }

    /**
     * Overrides the addAll method to count the total number of additions.
     *
     * @param integerList IntegerList containing elements to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean addAll(IntegerList integerList) {
        totalAdded += integerList.size(); // Increment the counter by the size of the input list
        return super.addAll(integerList);
    }

    /**
     * Returns the total number of elements that were attempted to be added
     * to the list (via both add and addAll methods).
     *
     * @return total number of attempted additions
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}

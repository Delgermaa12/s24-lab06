package edu.cmu.cs.cs214.rec04;



/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 */
public class InheritanceSortedIntList extends SortedIntList{
    private int totalAdded;
    public InheritanceSortedIntList() {
        super();
        this.totalAdded = 0;
    }

    /**
     * @param element 
     * @return 
     */
    @Override
    public boolean add(int element) {
        boolean isAdded = super.add(element);
        if (isAdded) {
            totalAdded++;
        }
        return isAdded;
    }

    /**
     * @param other 
     * @return 
     */
    @Override
    public boolean addAll(IntegerList other) {
        int countBefore = totalAdded; 
        boolean isAdded = super.addAll(other);
        if (isAdded) {
             totalAdded = countBefore + other.size(); 
        }
            return isAdded;
    }



    /**
     * @return 
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}

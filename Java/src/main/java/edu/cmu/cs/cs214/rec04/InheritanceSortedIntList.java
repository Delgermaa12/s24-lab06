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
    private int totalAdded; 
    public InheritanceSortedIntList() {
        super();
        totalAdded = 0;
    }

    /**
     * add niit nemegsen elementiin toog toolno.
     * @param num 
     * @return jagsaalt uurchlgdsun bol true
     */
    @Override
    public boolean add(int num) {
        totalAdded++;
        return super.add(num);
    }

    /** @param integerList IntegerList jagsaaltiig nemne
     * @return
     */
    @Override
    public boolean addAll(IntegerList integerList) {
        totalAdded += integerList.size();
        return super.addAll(integerList);
    }

    /**
     * @return
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}
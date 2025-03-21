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
    private final Sorted sortedList;
    private int totalAdded;
    public DelegationSortedIntList() {
        this.sortedList = new Sorted();
        this.totalAdded = 0; 
    }

    /**
     * @param num 
     * @return
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
     * @param list IntegerList бөгөөд энэ жагсаалтад нэмэгдэх элементүүдийг агуулна
     * @return жагсаалт өөрчлөгдсөн бол true
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
     * @param index 
     * @return 
     */
    @Override
    public int get(int index) {
        return sortedList.get(index);
    }

    /**
     * @param num
     * @return
     */
    @Override
    public boolean remove(int num) {
        return sortedList.remove(num);
    }

    /**
     * @param list 
     * @return 
     */
    @Override
    public boolean removeAll(IntegerList list) {
        return sortedList.removeAll(list);
    }

    /**
     * @return 
     */
    @Override
    public int size() {
        return sortedList.size();
    }

    /**
     * @return 
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}
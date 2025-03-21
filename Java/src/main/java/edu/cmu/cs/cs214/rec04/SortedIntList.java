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
    public SortedIntList() {
        list = new ArrayList<>();
    }

    /**
     * @param num 
     * @return
     */
    @Override
    public boolean add(int num) {
        list.add(num);
        Collections.sort(list); 
        return true;
    }

    /**
     * @param integerList 
     * @return 
     */
    @Override
    public boolean addAll(IntegerList integerList) {
        int initialSize = list.size();
        for (int i = 0; i < integerList.size(); i++) {
            list.add(integerList.get(i));
        }
        Collections.sort(list); 
        return list.size() > initialSize;
    }

    /**
     * @param index 
     * @return 
     */
    @Override
    public int get(int index) {
        return list.get(index);
    }

    /**
     * @param num 
     * @return 
     */
    @Override
    public boolean remove(int num) {
        return list.remove((Integer) num);
    }

    /**
     * @param integerList 
     * @return 
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
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return list.size();
    }
}

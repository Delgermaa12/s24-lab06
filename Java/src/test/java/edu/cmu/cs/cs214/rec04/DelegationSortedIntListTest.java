package edu.cmu.cs.cs214.rec04;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DelegationSortedIntListTest {

    private DelegationSortedIntList list1;
    private DelegationSortedIntList list2;

    @Before
    public void setUp() {
        list1 = new DelegationSortedIntList();
        list2 = new DelegationSortedIntList();
    }

    @Test
    public void testAdd() {
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);
        assertEquals(5, list1.getTotalAdded());
    }

    @Test
    public void testAddAll() {
        list1.add(1);
        list1.add(3);
        list1.add(2);

        assertEquals(3, list1.getTotalAdded());

        list2.add(4);
        list2.add(5);

        assertEquals(2, list2.getTotalAdded());

        list1.addAll(list2);

        assertEquals(5, list1.getTotalAdded());
    }

    /**
     * @param list 
     */
    private void printList(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(", ");
        }
        System.out.println();
    }
}

package coursera.sandiego.basicdatastructures.week3;

import org.junit.Test;

public class MaxHeapTest {

    @Test
    public void test() {
        MaxHeap maxHeap = new MaxHeap(10);
        System.out.println(maxHeap.getSize());
        maxHeap.insert(29);
        maxHeap.insert(18);
        maxHeap.insert(14);
        maxHeap.insert(7);
        maxHeap.insert(42);
        maxHeap.printHeap();
        System.out.println(maxHeap.getSize());
    }
}

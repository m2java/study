package coursera.sandiego.basicdatastructures.week3;

import org.junit.Test;

public class MaxHeapTest {

  @Test
  public void testInsert() {
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

  @Test
  public void testExtractMax() {
    MaxHeap maxHeap = new MaxHeap(10);
    maxHeap.insert(29);
    maxHeap.insert(18);
    maxHeap.insert(14);
    maxHeap.insert(7);
    maxHeap.insert(42);
    maxHeap.printHeap();
    System.out.println(maxHeap.getSize());
    maxHeap.extractMax();
    maxHeap.printHeap();
    System.out.println(maxHeap.getSize());
  }

  @Test
  public void testChangePriority() {
    MaxHeap maxHeap = new MaxHeap(10);
    maxHeap.insert(29);
    maxHeap.insert(18);
    maxHeap.insert(14);
    maxHeap.insert(7);
    maxHeap.insert(42);
    maxHeap.insert(13);
    maxHeap.printHeap();
    System.out.println(maxHeap.getSize());
    maxHeap.changePriority(2, 50);
    maxHeap.printHeap();
  }

  @Test
  public void testRemove() {
    MaxHeap maxHeap = new MaxHeap(10);
    maxHeap.insert(29);
    maxHeap.insert(18);
    maxHeap.insert(14);
    maxHeap.insert(7);
    maxHeap.insert(42);
    maxHeap.insert(13);
    maxHeap.printHeap();
    System.out.println(maxHeap.getSize());
    maxHeap.remove(1);
    maxHeap.printHeap();
    System.out.println(maxHeap.getSize());
  }
}

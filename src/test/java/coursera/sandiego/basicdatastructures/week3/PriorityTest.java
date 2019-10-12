package coursera.sandiego.basicdatastructures.week3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityTest {

  @Test
  public void test() {
    int[] inputArr =
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
    int n = inputArr.length;
    int m = 4;
    int[] threadsArr = new int[m];
    ArrayList<int[]> result = new ArrayList<>();

    //pre-work
    for (int i = 0; i < m; i++) {
      threadsArr[i] = inputArr[i];
      result.add(new int[] { i, 0 });
    }

    //work
    for (int i = m; i < n; i++) {
      int minTime = threadsArr[0];
      int minIndex = 0;
      for (int j = 1; j < m; j++) {
        if (minTime > threadsArr[j]) {
          minIndex = j;
          minTime = threadsArr[j];
        }
      }
      result.add(new int[] { minIndex, threadsArr[minIndex] });
      threadsArr[minIndex] = threadsArr[minIndex] + inputArr[i];
    }

    //print out
    result.forEach(x -> System.out.println(Arrays.toString(x)));
  }

  @Test
  public void testPriorityQueue() {
    int[] inputArr =
        { 1,2,3,4,5 };
    int n = inputArr.length;
    int m = 2;
    PriorityQueue<Thread> threadsArr = new PriorityQueue<>(m);
    ArrayList<int[]> result = new ArrayList<>();

    //pre-work
    for (int i = 0; i < m; i++) {
      Thread thread = new Thread(i, inputArr[i]);
      threadsArr.offer(thread);
      result.add(new int[] { thread.getNum(), 0 });
    }

    //work
    for (int i = m; i < n; i++) {
      Thread thread = threadsArr.poll();
      result.add(new int[] { thread.getNum(), thread.getEndOfwork() });
      thread.setEndOfwork(thread.getEndOfwork() + inputArr[i]);
      threadsArr.offer(thread);
    }

    //print out
    result.forEach(x -> System.out.println(Arrays.toString(x)));
  }

  public static class Thread implements Comparable<Thread> {
    private int num;
    private int endOfwork;

    public Thread(int num, int endOfwork) {
      this.num = num;
      this.endOfwork = endOfwork;
    }

    @Override
    public int compareTo(Thread o) {
     return Integer.compare(this.endOfwork, o.endOfwork);
    }

    public int getNum() {
      return num;
    }

    public void setNum(int num) {
      this.num = num;
    }

    public int getEndOfwork() {
      return endOfwork;
    }

    public void setEndOfwork(int endOfwork) {
      this.endOfwork = endOfwork;
    }
  }

}

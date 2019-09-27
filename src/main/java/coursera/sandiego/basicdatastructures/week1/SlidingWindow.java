package coursera.sandiego.basicdatastructures.week1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SlidingWindow {

  private int n;
  private int[] arr;
  private int m;

  public void read() {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    arr = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = scanner.nextInt();
    }
    m = scanner.nextInt();
  }

  public void solve() {
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 0; i < m; i++) {
      while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
        deque.removeLast();
      }
      deque.addLast(i);
    }

    for (int i = m; i < n; i++) {
      System.out.print(arr[deque.peek()] + " ");

      while (!deque.isEmpty() && deque.peek() <= i - m) {
        deque.removeFirst();
      }

      while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
        deque.removeLast();
      }

      deque.addLast(i);
    }
    System.out.print(arr[deque.peek()]);
  }

  public static void main(String[] args) {
    SlidingWindow slidingWindow = new SlidingWindow();
    slidingWindow.read();
    slidingWindow.solve();
  }

}

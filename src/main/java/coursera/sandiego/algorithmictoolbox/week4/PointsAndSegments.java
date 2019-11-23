package coursera.sandiego.algorithmictoolbox.week4;

import java.util.*;

public class PointsAndSegments {

  private static int[] fastCountSegments(int[] starts, int[] ends,
      int[] points) {
    int[] cnt = new int[points.length];
    PriorityQueue<Element> result =
        new PriorityQueue<>(Comparator.comparingInt(o -> o.number));
    for (int left : starts) {
      result.offer(new Element(left, Type.LEFT));
    }
    for (int right : ends) {
      result.offer(new Element(right, Type.RIGHT));
    }
    for (int point : points) {
      result.offer(new Element(point, Type.POINT));
    }
    int counter = 0;
    int pointCounter = 0;
    for (Element element : result) {
      if (element.type == Type.POINT) {
        cnt[pointCounter] = counter>=0?counter:0;
        counter = 0;
        ++pointCounter;
      } else if (element.type == Type.LEFT) {
        ++counter;
      } else {
        --counter;
      }
    } return cnt;
  }

  private static int[] naiveCountSegments(int[] starts, int[] ends,
      int[] points) {
    int[] cnt = new int[points.length];
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < starts.length; j++) {
        if (starts[j] <= points[i] && points[i] <= ends[j]) {
          cnt[i]++;
        }
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n, m;
    n = scanner.nextInt();
    m = scanner.nextInt();
    int[] starts = new int[n];
    int[] ends = new int[n];
    int[] points = new int[m];
    for (int i = 0; i < n; i++) {
      starts[i] = scanner.nextInt();
      ends[i] = scanner.nextInt();
    }
    for (int i = 0; i < m; i++) {
      points[i] = scanner.nextInt();
    }
    //use fastCountSegments
    int[] cnt = fastCountSegments(starts, ends, points);
    for (int x : cnt) {
      System.out.print(x + " ");
    }
  }

  private enum Type {
    POINT, LEFT, RIGHT
  }

  private static class Element {
    private int number;
    private Type type;

    Element(int number, Type type) {
      this.number = number;
      this.type = type;
    }

    @Override
    public String toString() {
      return "Element{" + "number=" + number + ", type=" + type + '}';
    }
  }
}

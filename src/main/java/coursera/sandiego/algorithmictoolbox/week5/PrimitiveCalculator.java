package coursera.sandiego.algorithmictoolbox.week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
  private static List<Integer> optimal_sequence(int n) {
    List<Integer> sequence = new ArrayList<Integer>();
    int[] numbers = new int[n + 1];
    numbers[0] = 0;
    numbers[1] = 0;
    for (int m = 2; m <= n; ++m) {
      sequence.add(m - 2, m - 1);
      numbers[m] = numbers[m - 1] + 1;
      if (m % 2 == 0) {
        if (numbers[m] > numbers[m / 2] + 1) {
          numbers[m] = numbers[m / 2] + 1;
          sequence.set(m - 2, m / 2);
        }
      }
      if (m % 3 == 0) {
        if (numbers[m] > numbers[m / 3] + 1) {
          numbers[m] = numbers[m / 3] + 1;
          sequence.set(m - 2, m / 3);
        }
      }
    }
    sequence.add(n);
    return handle(sequence);
  }

  private static List<Integer> handle(List<Integer> list) {
    List<Integer> result = new ArrayList<>();
    result.add(list.get(list.size()-1));
    for (int i = list.size() - 2; list.get(i) != 1; ) {
      result.add(list.get(i));
      i = list.get(i)-2;
    }
    result.add(1);
    Collections.reverse(result);
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> sequence = optimal_sequence(n);
    System.out.println(sequence.size() - 1);
    for (Integer x : sequence) {
      System.out.print(x + " ");
    }
  }
}

package coursera.sandiego.algorithmictoolbox.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
  private static List<Integer> optimalSummands(int n) {
    List<Integer> summands = new ArrayList<Integer>();
    int currNum = 1;
    while (currNum <= (n-1)/2) {
      summands.add(currNum);
      n-=currNum;
      ++currNum;
    }
    summands.add(n);
    return summands;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> summands = optimalSummands(n);
    System.out.println(summands.size());
    for (Integer summand : summands) {
      System.out.print(summand + " ");
    }
  }
}

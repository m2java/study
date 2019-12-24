package coursera.sandiego.algorithmictoolbox.week6;

import java.util.*;

public class PlacingParentheses {

  private static long getMaximValue(int[] numbers, String[] operations) {
    int n = numbers.length;
    int[][] m = new int[n][n];
    int[][] M = new int[n][n];
    for (int i = 0; i < n; ++i) {
      m[i][i] = numbers[i];
      M[i][i] = numbers[i];
    }
    for (int s = 1; s < n; ++s) {
      for (int i = 0; i < n - s; ++i) {
        int j = i + s;
        m[i][j] = minAndMax(i, j, m, M, operations)[0];
        M[i][j] = minAndMax(i, j, m, M, operations)[1];
      }
    }
    return M[0][n-1];
  }

  private static int[] minAndMax(int i, int j, int[][] m, int[][] M,
      String[] operations) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    for (int k = i; k <= j - 1; ++k) {
      a = eval(M[i][k], operations[k], M[k + 1][j]);
      b = eval(M[i][k], operations[k], m[k + 1][j]);
      c = eval(m[i][k], operations[k], M[k + 1][j]);
      d = eval(m[i][k], operations[k], m[k + 1][j]);
      min = Math.min(Math.min(Math.min(Math.min(min, a), b), c), d);
      max = Math.max(Math.max(Math.max(Math.max(max, a), b), c), d);
    }
    return new int[] { min, max };
  }

  private static int eval(int a, String op, int b) {
    switch (op) {
    case "+":
      return a + b;
    case "-":
      return a - b;
    case "*":
      return a * b;
    case "/":
      return a / b;
    }
    return -1;
  }

  private static List<Object[]> parse(String exp) {
    List<Object[]> list = new ArrayList<>();
    List<String> operationList = new ArrayList<>();
    List<Integer> numberList = new ArrayList<>();
    for (char ch : exp.toCharArray()) {
      if (Character.isDigit(ch)) {
        numberList.add(Integer.parseInt(String.valueOf(ch)));
        continue;
      }
      if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
        operationList.add(String.valueOf(ch));
      }
    }
    list.add(numberList.toArray());
    list.add(operationList.toArray());
    return list;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String exp = scanner.next();
    int[] numbers =
        Arrays.stream(parse(exp).get(0)).mapToInt(o -> (int) o).toArray();
    String[] operations = Arrays.asList(parse(exp).get(1))
        .toArray(new String[parse(exp).get(1).length]);
    System.out.println(getMaximValue(numbers, operations));
  }
}

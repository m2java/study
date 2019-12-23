package coursera.sandiego.algorithmictoolbox.week6;

import java.util.*;

public class Partition3 {
  private static int partition3(int[] A) {

    if (A.length < 3) {
      return 0;
    }

    int total = Arrays.stream(A).sum();
    if (total % 3 != 0) {
      return 0;
    }
    return isPartition(A, 0, 0, 0, total,
        new HashMap<>()) ? 1 : 0;
  }

  private static boolean isPartition(int[] arr, int index, int bucket1,
      int bucket2, int total, HashMap<String, Boolean> map) {
    String currentState = "" + index + bucket1 + bucket2;
    if (map.containsKey(currentState)) {
      return map.get(currentState);
    }

    if (index >= arr.length || bucket1 > (total / 3) || bucket2 > (total / 3)) {
      return false;
    }

    if (bucket1 * 3 == total && bucket2 == bucket1) {
      return true;
    }
    boolean result = isPartition(arr, index + 1, bucket1, bucket2, total, map)
        || isPartition(arr, index + 1, bucket1 + arr[index], bucket2, total,
        map) || isPartition(arr, index + 1, bucket1, bucket2 + arr[index],
        total, map);
    map.put(currentState, result);
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = scanner.nextInt();
    }
    System.out.println(partition3(A));
  }
}

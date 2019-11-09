package coursera.sandiego.algorithmictoolbox.week3;

import java.util.Scanner;

public class CarFueling {
  static int computeMinRefills(int dist, int tank, int[] stops) {
    int[] route = new int[stops.length + 2];
    route[0] = 0;
    route[route.length - 1] = dist;
    System.arraycopy(stops, 0, route, 1, stops.length);
    int currPosition = 0;
    int refills = 0;
    while (currPosition < route.length) {
      int currentTank = tank;
      int newPosition = currPosition;
      for (int j = currPosition + 1; j < route.length; ++j) {
        if (currentTank - (route[j] - route[newPosition]) >= 0) {
          currentTank -= (route[j] - route[newPosition]);
          newPosition = j;
        } else {
          break;
        }
      }
      if (currPosition == newPosition) {
        return -1;
      }
      if (newPosition == route.length - 1) {
        break;
      }
      currPosition = newPosition;
      ++refills;
    }
    return refills;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int dist = scanner.nextInt();
    int tank = scanner.nextInt();
    int n = scanner.nextInt();
    int stops[] = new int[n];
    for (int i = 0; i < n; i++) {
      stops[i] = scanner.nextInt();
    }

    System.out.println(computeMinRefills(dist, tank, stops));
  }
}

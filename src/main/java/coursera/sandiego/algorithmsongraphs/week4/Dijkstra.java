package coursera.sandiego.algorithmsongraphs.week4;

import java.util.*;

public class Dijkstra {
  private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
    int[] dist = new int[adj.length];
    int[] prev = new int[adj.length];
    int[] unknownRegion = new int[adj.length];
    for (int i = 0; i < adj.length; ++i) {
      dist[i] = Integer.MAX_VALUE/2;
      prev[i] = -1;
      unknownRegion[i] = Integer.MAX_VALUE/2;
    }
    dist[s] = 0;
    unknownRegion[s] = 0;
    while (present(unknownRegion)) {
      int u = extractMin(unknownRegion);
      ArrayList<Integer> list = adj[u];
      ArrayList<Integer> wieght = cost[u];
      for (int i = 0; i < list.size(); ++i) {
        int v = list.get(i);
        int w = wieght.get(i);
        if (dist[v] > dist[u] + w) {
          dist[v] = dist[u] + w;
          prev[v] = u;
          unknownRegion[v] = dist[v];
        }
      }
    }
    return dist[t];
  }

  public static int extractMin(int[] unknownRegion) {
    int minValue = Integer.MAX_VALUE;
    int minIndex = -1;
    for (int i = 0; i < unknownRegion.length; ++i) {
      if (unknownRegion[i] >= 0 && unknownRegion[i] <= minValue) {
        minValue = unknownRegion[i];
        minIndex = i;
      }
    }
    unknownRegion[minIndex] = -1;
    return minIndex;
  }

  public static boolean present(int[] unknownRegion) {
    for (int i = 0; i < unknownRegion.length; ++i) {
      if (unknownRegion[i] != -1) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
    ArrayList<Integer>[] cost = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<Integer>();
      cost[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < m; i++) {
      int x, y, w;
      x = scanner.nextInt();
      y = scanner.nextInt();
      w = scanner.nextInt();
      adj[x - 1].add(y - 1);
      cost[x - 1].add(w);
    }
    int x = scanner.nextInt() - 1;
    int y = scanner.nextInt() - 1;
    System.out.println(distance(adj, cost, x, y));
  }
}


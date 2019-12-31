package coursera.sandiego.algorithmsongraphs.week1;

import java.util.*;

public class Reachability {

  private static int reach(List<Integer>[] adj, int x, int y) {
    List<Integer> visited = new ArrayList<>();
    Queue<Integer> toVisit = new LinkedList<>();
    visited.add(x);
    return exploreBefore(adj[x], visited, toVisit, y, adj);
  }

  private static int exploreBefore(List<Integer> adjList, List<Integer> visited, Queue<Integer> toVisit, int y, List<Integer>[] adj) {
    if (adjList.contains(y)) {
      return 1;
    }

    for (int vertex: adjList) {
      if (visited.contains(vertex)) {
       continue;
      } else {
        toVisit.offer(vertex);
      }
    }

    if (toVisit.size() == 0) {
      return 0;
    }
    int nextToVisit = toVisit.poll();
    visited.add(nextToVisit);
    return exploreBefore(adj[nextToVisit], visited, toVisit, y, adj);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    List<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; ++i) {
      adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; ++i) {
      int x, y;
      x = scanner.nextInt();
      y = scanner.nextInt();
      adj[x - 1].add(y - 1);
      adj[y - 1].add(x - 1);
    }
    int x = scanner.nextInt() - 1;
    int y = scanner.nextInt() - 1;
    System.out.println(reach(adj, x, y));
  }
}


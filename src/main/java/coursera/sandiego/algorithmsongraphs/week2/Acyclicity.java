package coursera.sandiego.algorithmsongraphs.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Acyclicity {
  private static int n;
  private static int m;
  private static boolean[] visited;
  private static int[] pre;
  private static int[] post;
  private static ArrayList<Integer>[] adj;
  private static int clock = 1;

  private static int acyclic(ArrayList<Integer>[] adj) {
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        pre(i);
        explore(i);
        post(i);
      }
    }
    return check();
  }

  public static int check() {
    for (int u = 0; u < n; ++u) {
      ArrayList<Integer> list = adj[u];
      for (int v : list) {
        if (post[v] > post[u]) {
          return 1;
        }
      }
    }
    return 0;
  }

  public static void explore(int v) {
    //System.out.println(v + 1);
    ArrayList<Integer> list = adj[v];
    for (int subvertix : list) {
      if (!visited[subvertix]) {
        visited[subvertix] = true;
        pre(subvertix);
        explore(subvertix);
        post(subvertix);
      }
    }
  }

  public static void pre(int v) {
    pre[v] = clock;
    clock++;
  }

  public static void post(int v) {
    post[v] = clock;
    clock++;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();
    visited = new boolean[n];
    pre = new int[n];
    post = new int[n];
    adj = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
      int x, y;
      x = scanner.nextInt();
      y = scanner.nextInt();
      adj[x - 1].add(y - 1);
    }
    System.out.println(acyclic(adj));
    //System.out.println(Arrays.toString(post));
  }
}


package coursera.sandiego.algorithmsongraphs.week5;

import java.util.*;

public class Clustering {
  private static double clustering(int[] x, int[] y, int k) {
    double result = 0.;
    List<Point> pointList = createPointList(x, y);
    int[] disjointSets = createDisjointSets(pointList.size());
    Queue<Edge> edgesQueue = createEdgesQueue(pointList);
    for (int i = 0; i < edgesQueue.size(); ++i) {
      Edge edge = edgesQueue.poll();
      if (find(edge.u, disjointSets) != find(edge.v, disjointSets)) {
        result = edge.cost;
        union(edge.u, edge.v, disjointSets);
        if (check(disjointSets, k) && edgesQueue.size() > 0) {
          return edgesQueue.poll().cost;
        }
      }
    }
    return result;
  }

  private static boolean check(int[] disjointSets, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : disjointSets) {
        map.merge(i,1, (a,b) -> a + b);
      }
    return map.size() == k;
  }

  private static List<Point> createPointList(int[] x, int[] y) {
    List<Point> result = new ArrayList<>();
    for (int i = 0; i < x.length; ++i) {
      result.add(new Point(i, x[i], y[i]));
    }
    return result;
  }

  private static int[] createDisjointSets(int points) {
    int[] result = new int[points];
    for (int i = 0; i < points; ++i) {
      result[i] = i;
    }
    return result;
  }

  private static Queue<Edge> createEdgesQueue(List<Point> points) {
    Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.cost));
    for (int i = 0; i < points.size() - 1; ++i) {
      for (int j = i + 1; j < points.size(); ++j) {
        queue.offer(new Edge(points.get(i), points.get(j)));
      }
    }
    return queue;
  }

  private static int find(Point u, int[] disjointSets) {
    return disjointSets[u.getId()];
  }

  private static void union(Point u, Point v, int[] disjointSets) {
    for (int i = 0; i < disjointSets.length; ++i) {
      if (disjointSets[i] == v.getId()) {
        disjointSets[i] = disjointSets[u.getId()];
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = scanner.nextInt();
      y[i] = scanner.nextInt();
    }
    int k = scanner.nextInt();
    System.out.println(clustering(x, y, k));
  }


  private static class Point {
    private int id;
    private int x;
    private int y;

    public Point(int id, int x, int y) {
      this.id = id;
      this.x = x;
      this.y = y;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public int getX() {
      return x;
    }

    public void setX(int x) {
      this.x = x;
    }

    public int getY() {
      return y;
    }

    public void setY(int y) {
      this.y = y;
    }
  }

  private static class Edge {
    private Point v;
    private Point u;
    private double cost;

    public Edge(Point u, Point v) {
      this.u = u;
      this.v = v;
      this.cost = calculateDistance(u, v);
    }

    private double calculateDistance(Point u, Point v) {
      return Math.sqrt(Math.pow(u.getX() - v.getX(), 2) + Math.pow(u.getY() - v.getY(), 2));
    }
  }
}


package coursera.sandiego.basicdatastructures.week3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
  private int[] data;
  private List<Swap> swaps;
  private int n;

  private FastScanner in;
  private PrintWriter out;

  public BuildHeap() {
    swaps = new ArrayList<>();
  }

  public static void main(String[] args) throws IOException {
    new BuildHeap().solve();
  }

  private void readData() throws IOException {
    n = in.nextInt();
    data = new int[n];
    for (int i = 0; i < n; ++i) {
      data[i] = in.nextInt();
    }
  }

  private void writeResponse() {
    out.println(swaps.size());
    for (Swap swap : swaps) {
      out.println(swap.index1 + " " + swap.index2);
    }
  }

  private void generateSwaps() {
    // The following naive implementation just sorts
    // the given sequence using selection sort algorithm
    // and saves the resulting sequence of swaps.
    // This turns the given array into a heap,
    // but in the worst case gives a quadratic number of swaps.
    //
    // TODO: replace by a more efficient implementation
/*    for (int i = 0; i < data.length; ++i) {
      for (int j = i + 1; j < data.length; ++j) {
        if (data[i] > data[j]) {
          swaps.add(new Swap(i, j));
          int tmp = data[i];
          data[i] = data[j];
          data[j] = tmp;
        }
      }
    }*/

    for (int i = n / 2 + 1; i >= 0; i--) {
      siftDown(i);
    }
  }

  private void siftDown(int index) {
    while (index < n) {
      int leftId = index * 2 + 1;
      int rightId = index * 2 + 2;

      if (leftId > n - 1 && rightId > n - 1) {
        break;
      }

      if (leftId <= n - 1 && rightId > n - 1) {
        if (data[index] > data[leftId]) {
          Swap swap = new Swap(index, leftId);
          swaps.add(swap);
          swap.makeSwap(data);
          index = leftId;
          continue;
        } else {
          break;
        }
      }

      if (leftId > n - 1 && rightId <= n - 1) {
        if (data[index] > data[rightId]) {
          Swap swap = new Swap(index, rightId);
          swaps.add(swap);
          swap.makeSwap(data);
          index = rightId;
          continue;
        } else {
          break;
        }
      }

      if (leftId <= n - 1 && rightId <= n - 1) {
        int minId;
        if (data[leftId] <= data[rightId]) {
          minId = leftId;
        } else {
          minId = rightId;
        }
        if (data[index] > data[minId]) {
          Swap swap = new Swap(index, minId);
          swaps.add(swap);
          swap.makeSwap(data);
          index = minId;
          continue;
        } else {
          break;
        }
      }
    }
  }

  public void solve() throws IOException {
    in = new FastScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    readData();
    generateSwaps();
    writeResponse();
    out.close();
  }

  static class Swap {
    int index1;
    int index2;

    public Swap(int index1, int index2) {
      this.index1 = index1;
      this.index2 = index2;
    }

    public void makeSwap(int[] data) {
      int tmp = data[index1];
      data[index1] = data[index2];
      data[index2] = tmp;
    }
  }

  static class FastScanner {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastScanner() {
      reader = new BufferedReader(new InputStreamReader(System.in));
      tokenizer = null;
    }

    public String next() throws IOException {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        tokenizer = new StringTokenizer(reader.readLine());
      }
      return tokenizer.nextToken();
    }

    public int nextInt() throws IOException {
      return Integer.parseInt(next());
    }
  }
}
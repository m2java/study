package coursera.sandiego.basicdatastructures.week3;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {
  private int numWorkers;
  private int[] jobs;

  private int[] assignedWorker;
  private long[] startTime;

  private FastScanner in;
  private PrintWriter out;

  public static void main(String[] args) throws IOException {
    new JobQueue().solve();
  }

  private void readData() throws IOException {
    numWorkers = in.nextInt();
    int m = in.nextInt();
    jobs = new int[m];
    for (int i = 0; i < m; ++i) {
      jobs[i] = in.nextInt();
    }
  }

  private void writeResponse() {
    for (int i = 0; i < jobs.length; ++i) {
      out.println(assignedWorker[i] + " " + startTime[i]);
    }
  }

  private void assignJobs() {
/*    // TODO: replace this code with a faster algorithm.
    assignedWorker = new int[jobs.length];
    startTime = new long[jobs.length];
    long[] nextFreeTime = new long[numWorkers];
    for (int i = 0; i < jobs.length; i++) {
      int duration = jobs[i];
      int bestWorker = 0;
      for (int j = 0; j < numWorkers; ++j) {
        if (nextFreeTime[j] < nextFreeTime[bestWorker])
          bestWorker = j;
      }
      assignedWorker[i] = bestWorker;
      startTime[i] = nextFreeTime[bestWorker];
      nextFreeTime[bestWorker] += duration;
    }*/
    assignedWorker = new int[jobs.length];
    startTime = new long[jobs.length];
    long[] nextFreeTime = new long[numWorkers];

    PriorityQueue<Thread> threadsArr = new PriorityQueue<>(numWorkers);
    for (int i = 0; i < numWorkers; ++i) {
      threadsArr.offer(new Thread(i, jobs[i]));
    }

    for (int i = numWorkers; i < jobs.length; i++) {
      int duration = jobs[i];

      Thread bestWorkerThread = threadsArr.poll();
      int bestWorker = bestWorkerThread.getNum();

      assignedWorker[i] = bestWorker;
      startTime[i] = nextFreeTime[bestWorker];
      nextFreeTime[bestWorker] += duration;
      bestWorkerThread.setEndOfwork(nextFreeTime[bestWorker]);
      threadsArr.offer(bestWorkerThread);
    }

  }

  public void solve() throws IOException {
    in = new FastScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    readData();
    assignJobs();
    writeResponse();
    out.close();
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

  public static class Thread implements Comparable<Thread> {
    private int num;
    private long endOfwork;

    public Thread(int num, long endOfwork) {
      this.num = num;
      this.endOfwork = endOfwork;
    }

    @Override
    public int compareTo(Thread o) {
      return Long.compare(this.endOfwork, o.endOfwork);
    }

    public int getNum() {
      return num;
    }

    public void setNum(int num) {
      this.num = num;
    }

    public long getEndOfwork() {
      return endOfwork;
    }

    public void setEndOfwork(long endOfwork) {
      this.endOfwork = endOfwork;
    }
  }
}
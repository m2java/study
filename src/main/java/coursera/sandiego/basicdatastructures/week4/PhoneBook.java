package coursera.sandiego.basicdatastructures.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PhoneBook {

  private FastScanner in = new FastScanner();
  private String[] contacts = new String[10000000];

  public static void main(String[] args) {
    new PhoneBook().processQueries();
  }

  private Query readQuery() {
    String type = in.next();
    int number = in.nextInt();
    if (type.equals("add")) {
      String name = in.next();
      return new Query(type, name, number);
    } else {
      return new Query(type, number);
    }
  }

  private void writeResponse(String response) {
    System.out.println(response);
  }

  private void processQuery(Query query) {
    if (query.type.equals("add")) {
      contacts[query.number] = query.name;
    } else if (query.type.equals("find")) {
      String response = contacts[query.number];
      if (response == null) {
        response = "not found";
      }
      writeResponse(response);
    } else if (query.type.equals("del")) {
      contacts[query.number] = null;
    }
  }

  public void processQueries() {
    int lines = in.nextInt();
    for (int i = 0; i < lines; ++i) {
      processQuery(readQuery());
    }
  }

  static class Query {
    String type;
    String name;
    int number;

    public Query(String type, String name, int number) {
      this.type = type;
      this.name = name;
      this.number = number;
    }

    public Query(String type, int number) {
      this.type = type;
      this.number = number;
    }
  }

  class FastScanner {
    private BufferedReader br;
    private StringTokenizer st;

    FastScanner() {
      this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

  }
}

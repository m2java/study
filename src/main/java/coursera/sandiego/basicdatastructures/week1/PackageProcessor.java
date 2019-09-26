package coursera.sandiego.basicdatastructures.week1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PackageProcessor {

  public ArrayList<Request> readQueries(Scanner scanner) throws IOException {
    int requestsCount = scanner.nextInt();
    ArrayList<Request> requests = new ArrayList<>();
    for (int i = 0; i < requestsCount; ++i) {
      int arrivalTime = scanner.nextInt();
      int processTime = scanner.nextInt();
      requests.add(new Request(arrivalTime, processTime));
    }
    return requests;
  }

  public ArrayList<Response> processRequests(ArrayList<Request> requests,
      Buffer buffer) {
    ArrayList<Response> responses = new ArrayList<>();
    for (int i = 0; i < requests.size(); ++i) {
      responses.add(buffer.process(requests.get(i)));
    }
    return responses;
  }

  public void printResponses(ArrayList<Response> responses) {
    for (int i = 0; i < responses.size(); ++i) {
      Response response = responses.get(i);
      if (response.dropped) {
        System.out.println(-1);
      } else {
        System.out.println(response.startTime);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int bufferMaxSize = scanner.nextInt();
    Buffer buffer = new Buffer(bufferMaxSize);

    PackageProcessor packageProcessor = new PackageProcessor();
    ArrayList<Request> requests = packageProcessor.readQueries(scanner);
    ArrayList<Response> responses = packageProcessor.processRequests(requests, buffer);
    packageProcessor.printResponses(responses);
  }

}

package coursera.sandiego.basicdatastructures.week1;

import java.util.ArrayList;

public class Buffer {
  private int size;
  private ArrayList<Integer> finishTime;
  private int processingStartTime;

  public Buffer(int size) {
    this.size = size;
    this.finishTime = new ArrayList<>();
    this.processingStartTime = 0;
  }

  public Response process(Request request) {

    if (finishTime.size() == 0) {
      return new Response(true, processingStartTime);
    } else {
      if (finishTime.get(0) <= request.arrivalTime) {
        finishTime.add(request.arrivalTime + request.processTime);
        return new Response(true, request.arrivalTime);
      } else {
        if (finishTime.size() < size) {
          finishTime.add(request.arrivalTime + request.processTime);
        } else {
          return new Response(false, -1);
        }
      }
    }
  }
}

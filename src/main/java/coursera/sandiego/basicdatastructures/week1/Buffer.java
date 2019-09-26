package coursera.sandiego.basicdatastructures.week1;

import java.util.ArrayList;

public class Buffer {
    private int size;
    private ArrayList<Integer> finishTime;

    public Buffer(int size) {
        this.size = size;
        this.finishTime = new ArrayList<>();
    }

    public Response process(Request request) {
        if (finishTime.isEmpty()) {
            finishTime.add(request.arrivalTime + request.processTime);
            return new Response(false, request.arrivalTime);
        } else if (finishTime.get(0) <= request.arrivalTime) {
            finishTime.remove(0);
            if (finishTime.isEmpty()) {
                finishTime.add(request.arrivalTime + request.processTime);
                return new Response(false, request.arrivalTime);
            } else {
                finishTime.add(finishTime.get(finishTime.size()-1) + request.processTime);
                return new Response(false, finishTime.get(finishTime.size()-1));
            }
        } else if (finishTime.size() < size) {
            finishTime.add(finishTime.get(finishTime.size()-1) + request.processTime);
            return new Response(false, finishTime.get(finishTime.size()-1));
        } else {
            return new Response(true, -1);
        }
    }
}


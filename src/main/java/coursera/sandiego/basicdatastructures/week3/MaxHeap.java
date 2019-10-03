package coursera.sandiego.basicdatastructures.week3;

public class MaxHeap {
    private int[] arr;
    private int size;
    private int capacity;

    public MaxHeap(int cap) {
        this.capacity = cap;
        arr = new int[capacity];
        size = 0;
    }

    public int getMax() {
        return arr[0];
    }

    public void insert(int input) {
        if (size != capacity) {
            arr[size] = input;
            siftUp(size);
            size++;
        }
    }

    private void siftUp(int index) {
        while (index != 0) {
            int parentId = (index-1) / 2;
            if (arr[index] > arr[parentId]) {
                int tmp = arr[parentId];
                arr[parentId] = arr[index];
                arr[index] = tmp;
                index = parentId;
            } else {
                break;
            }
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}

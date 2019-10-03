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

  public int extractMax() {
    int result = arr[0];
    arr[0] = arr[size-1];
    siftDown(0);
    size--;
    return result;
  }

  private void siftUp(int index) {
    while (index != 0) {
      int parentId = (index - 1) / 2;
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

  private void siftDown(int index) {
    while (index < size) {
      int leftId = 2 * index + 1;
      int rightId = 2 * index + 2;
      if (leftId <= size && arr[index] < arr[leftId] && (
          arr[index] >= arr[rightId] || rightId > size)) {
        int tmp = arr[leftId];
        arr[leftId] = arr[index];
        arr[index] = tmp;
        index = leftId;
      } else if (rightId <= size && arr[index] < arr[rightId] && (
          arr[index] >= arr[leftId] || leftId > size)) {
        int tmp = arr[rightId];
        arr[rightId] = arr[index];
        arr[index] = tmp;
        index = rightId;
      } else if (leftId <= size && rightId <= size && arr[index] < arr[leftId]
          && arr[index] < arr[rightId]) {
        int swapId;
        if (arr[leftId] >= arr[rightId]) {
          swapId = leftId;
        } else {
          swapId = rightId;
        }
        int tmp = arr[swapId];
        arr[swapId] = arr[index];
        arr[index] = tmp;
        index = swapId;
      } else {
        break;
      }
    }
  }

  public void changePriority(int index, int value) {
    int oldValue = arr[index];
    arr[index] = value;
    if (oldValue < value) {
      siftUp(index);
    } else {
      siftDown(index);
    }
  }

  public int remove(int index) {
    int result = arr[index];
    arr[index] = Integer.MAX_VALUE;
    siftUp(index);
    extractMax();
    return result;
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

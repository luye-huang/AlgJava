// 优先队列 最大或最小n个元素，多路归并
// 插入logn，取出logn
public class Heap {
    private int[] data;
    private int count;
    private int capacity;

    public Heap(int capacity) {
        data = new int[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    public void insert(int value) {
        data[++count] = value;
        shiftUp(count);
    }

    public int get() {
        int value = data[1];
        data[1] = data[count--];
        shiftDown(1);
        return value;
    }

    private void shiftDown(int n) {
        int child = 2 * n;
        while (child <= count) {
            if (child + 1 <= count && data[child + 1] > data[child]) {
                child++;
            }
            if (data[n] < data[child]) {
                swap(n, child);
                shiftDown(child);
            } else {
                break;
            }
        }
    }

    private void shiftUp(int n) {
        int parent = n / 2;
        while (parent > 0) {
            if (data[n] > data[parent]) {
                swap(n, parent);
                shiftUp(parent);
            } else {
                break;
            }
        }
    }

    private void swap(int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public void heapify(int[] data) {
        this.data = new int[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            this.data[i + 1] = data[i];
        }
        this.count = data.length;
        for (int i = count / 2; i > 0; i--) {
            shiftDown(i);
        }
    }


    public static void main(String[] args) {
        Heap heap = new Heap(100);
        heap.heapify(new int[]{2, 5, 7, 4, 11, 1});
//        heap.insert(400000);
//        heap.insert(4);
//        heap.insert(1333);
//        heap.insert(133);
//        heap.insert(2333);
//        heap.insert(11333);
//        heap.insert(-11333);
        System.out.println(heap.get());
        System.out.println(heap.get());
        System.out.println(heap.get());
        System.out.println(heap.get());
        System.out.println(heap.get());
        System.out.println(heap.get());
    }
}

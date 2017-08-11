package org.xiaoyang.heap.maxheap;

/**
 * 最大堆(优先队列), 使用常用的方法，数组从 1 开始统计
 */
public class MaxHeap<T extends Comparable> {

    private T[] item;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        this.item = (T[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public void print() {
        for (int i = 1; i <= count; i++) {
            System.out.print(item[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(T element) {
        if (count + 1 > capacity) {
            throw new ArrayIndexOutOfBoundsException(capacity);
        }
        item[count + 1] = element;
        count++;
        shiftUp(count);
    }

    public T extractMax() {
        T result = item[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return result;
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && item[j].compareTo(item[j + 1]) < 0) {
                j += 1;
            }

            if (item[k].compareTo(item[j]) > 0)
                break;

            swap(j, k);
            k = j;
        }
    }

    private void shiftUp(int k) {
        while (k > 1 && item[k].compareTo(item[k / 2]) > 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void swap(int x, int y) {
        T tmp = item[x];
        item[x] = item[y];
        item[y] = tmp;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>(20);
        for (int i = 0; i < 15; i++) {
            heap.insert((int) (Math.random() * 100 + 1));
        }
        heap.print();
        Integer max = heap.extractMax();
        System.out.println(max);
        heap.print();
    }

}

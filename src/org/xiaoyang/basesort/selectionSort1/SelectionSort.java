package org.xiaoyang.basesort.selectionSort1;

/**
 * 选择排序,学习排序算法
 * 选择排序，先选出合适的（最大或者最小）放到前面，一次类推
 * <p>
 * 复杂度 O(n^2)
 */
public class SelectionSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

    }
}

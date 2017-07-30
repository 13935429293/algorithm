package test;

import org.xiaoyang.helper.SortTestHelper;

import java.util.Arrays;

/**
 * 复杂度为 O(n^2) 的排序
 */
public class BaseSortTest {

    /**
     * 选择排序，每一次内层循环选取最小的放到前面，交换位置，内层循环和标志位作比较
     *
     * @param arr
     */
    public static void selectionSort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 存放最小值的索引
            int minIndex = i;
            // 内层循环找出比最小索引值小的，交换位置
            for (int j = i; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 插入排序
     * <p>
     * 内层循环将小的插入到合适的位置，内层循环和标志位作比较
     * 将当前元素复制一份，判断当前的元素是否应该放在这个位置，判断的标准是是否小于或者大于他前面的元素，
     * 如果不应该放到当前位置，将前面的元素放到当前的位置，找到合适的位置后，将复制的副本放到当前位置即可
     *
     * @param arr
     */
    public static void insertionSort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable t = arr[i];
            int j = i;
            for (; j >= 1 && arr[j - 1].compareTo(t) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    /**
     * 希尔排序
     * <p>
     * 将数组对象通过制定的步长进行分组排序，在减小步长，最后一步进行一次插入排序
     *
     * @param arr
     */
    public static void shellSort(Comparable[] arr) {

        int n = arr.length;
        int h = 1;
        while (h < n / 3)
            h = 3 * h + 1;

        for (; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for (; j >= h && arr[j - h].compareTo(e) > 0; j -= h)
                    arr[j] = arr[j - h];
                arr[j] = e;
            }
        }
    }

    /**
     * 交换arr中 i 与 j 的位置
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10000, 0, 10000);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("test.BaseSortTest", "selectionSort", arr);
        SortTestHelper.testSort("test.BaseSortTest", "insertionSort", arr1);
        SortTestHelper.testSort("test.BaseSortTest", "shellSort", arr2);
        SortTestHelper.printArray(arr);
        SortTestHelper.printArray(arr1);
        SortTestHelper.printArray(arr2);
    }
}

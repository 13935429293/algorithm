package test;

import org.xiaoyang.helper.SortTestHelper;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSortTest {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = (l + r) >> 1;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] tmp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = tmp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = tmp[i - l];
                i++;
            } else if (tmp[i - l].compareTo(tmp[j - l]) > 0) {
                arr[k] = tmp[j - l];
                j++;
            } else {
                arr[k] = tmp[i - l];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(100000, 0, 100000);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("test.InsertionSortTest", arr);
        SortTestHelper.testSort("test.SelectionSortTest", arr1);
        SortTestHelper.testSort("test.MergeSortTest", arr2);
    }
}

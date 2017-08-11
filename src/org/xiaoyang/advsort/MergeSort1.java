package org.xiaoyang.advsort;

import org.xiaoyang.helper.SortTestHelper;

import java.util.Arrays;

/**
 * 归并排序，自底向上执行，不需要递归算法，不通过数组的下标进行排序，可实现队链表的排序
 */
public class MergeSort1 {

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(20, 0, 30);
        MergeSort1.sort(arr);
        SortTestHelper.printArray(arr);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 对进行merge的元素个数进行遍历
        for (int size = 1; size < n; size *= 2) {
            // 每一轮在归并的过程中起始的元素位置
            for (int i = 0; i < n - size; i += 2 * size) {
                // 对 arr[size...2*size-1] 和 arr[2*size...3*size-1] 进行归并
                merge(arr, i, i + size - 1, Math.min(i + 2 * size - 1, n - 1)/*防止越界*/);
            }
        }
    }

    public static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] tmp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = tmp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = tmp[i - l];
                i++;
            } else if (tmp[i - l].compareTo(tmp[j - l]) < 0) {
                arr[k] = tmp[i - l];
                i++;
            } else {
                arr[k] = tmp[j - l];
                j++;
            }
        }
    }
}

package org.xiaoyang.basesort.insertionSort2;

import org.xiaoyang.helper.SortTestHelper;

import java.util.Arrays;

/**
 * 改进 org.xiaoyang.basesort.insertionSort1 中的插入排序，减少交换的次数
 * <p>
 * 插入排序的一个重要的特点就是可以提前终止内层循环，当排序对象为近乎有序的数组时，复杂度为 O(n)
 */
public class InsertionSort {

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable t = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(t) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }


    public static void sort(Comparable[] arr, int l, int r) {
        assert l >= 0 && l <= r && r < arr.length;

        for (int i = l; i <= r; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(e) > 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }

    public static void main(String[] args) {

        Integer[] arr = SortTestHelper.generateRandomArray(30, 0, 100);
        InsertionSort.sort(arr, 5, 20);
        SortTestHelper.printArray(arr);
        //Integer[] arr = SortTestHelper.generateRandomArray(10000, 0, 3);
        //Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        //Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        //SortTestHelper.testSort("org.xiaoyang.basesort.selectionSort2.SelectionSort", arr);
        //SortTestHelper.testSort("org.xiaoyang.basesort.insertionSort1.InsertionSort", arr1);
        //SortTestHelper.testSort("org.xiaoyang.basesort.insertionSort2.InsertionSort", arr2);

    }
}

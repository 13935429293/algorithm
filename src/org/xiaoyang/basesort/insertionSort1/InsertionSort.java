package org.xiaoyang.basesort.insertionSort1;

import org.xiaoyang.helper.SortTestHelper;

import java.util.Arrays;

/**
 * 插入排序
 *  * 第一个位置已经排序好，处理第二个位置的元素。插入到合适的位置，如果已经排序好，继续下一轮插入,可以提前终止一次循环
 *
 *  diff SelectionSort
 * 将对应的插入到前面合适的位置，整理扑克牌
 */
public class InsertionSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 寻找元素 arr[i] 合适的位置插入
            // 判断是否比前一个小,
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);// 交换空间消耗时间
            }
        }
    }

    private static void swap(Comparable[] arr, int j, int i) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10000, 0, 300000);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("org.xiaoyang.basesort.insertionSort1.InsertionSort", arr);
        SortTestHelper.testSort("org.xiaoyang.basesort.selectionSort2.SelectionSort", arr1);
        SortTestHelper.printArray(arr);
        SortTestHelper.printArray(arr1);
    }
}

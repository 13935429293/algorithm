package org.xiaoyang.advsort;

import org.xiaoyang.helper.SortTestHelper;

import java.util.Arrays;

public class QuickSort {

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {

        int ran = (int) (Math.random() * (r - l + 1));
        swap(arr, l, ran + l);

        Comparable v = arr[l];// 最左侧的元素，快速排序可以优化为随机获取一个值
        // v | arr < v | arr > v | i;
        // arr[l+1...j] < v ; arr[j+1...i) > v i这个元素是当前正在判断的元素
        int j = l;// 初始值是l arr[l+1...j] 为空，不存在，arr[j+1...i) 也不存在
        for (int i = l + 1; i <= r ; i++) {
            if (arr[i].compareTo(v) < 0) {
                // 将元素放到了j的后面，并且j的下标需要移动
                swap(arr, ++j, i);
            }
        }
        // 将 v所在的元素和 j 所在的元素位置调换
        swap(arr, l, j);
        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        //Integer[] arr = SortTestHelper.generateRandomArray(1000000, 0, 1000000);
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(1000000, 0);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("org.xiaoyang.advsort.QuickSort", arr);
        SortTestHelper.testSort("org.xiaoyang.advsort.MergeSort1", arr1);
    }
}

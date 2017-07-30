package org.xiaoyang.advsort;

import org.xiaoyang.basesort.insertionSort2.InsertionSort;
import org.xiaoyang.helper.SortTestHelper;

import java.util.Arrays;

/**
 * 归并排序(自顶向下的执行)
 *
 * 个人理解：将数组递归拆分成最小单元，进行归并
 *  归并：
 *      1、原数组复制一份，左侧数组的结尾作为复制数组的中间位置
 *      2、如果左侧数组的元素小于右侧数组，将左侧数组放到原来数组中，左侧下标移动一位，右侧也是这样
 *      3、如果左侧下表已经到了中间位置，将右侧的复制即可，移动下标位置
 */
public class MergeSort {

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 递归使用归并排序,对arr[l...r]的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void sort(Comparable[] arr, int l, int r) {

        if (l >= r)
            return;
        // 优化 档达到一定量级的时候，可以使用插入排序
        //if (r - l <= 15) {
        //    InsertionSort.sort(arr, l, r);
        //    return;
        //}

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 左边是排序后的，右面也是排序后的，左侧是最大值大于右侧的最大值，才需要做归并
        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     *
     * @param arr
     * @param l
     * @param r
     * @param mid
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        // 创建临时数组，大小为归并数组的范围，复制好的数组重新排序到原数组中
        Comparable[] tmp = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) { // 如果左半部分元素已经全部处理完毕，下一个就应该是右半部分的元素
                arr[k] = tmp[j - l];
                j++;
            } else if (j > r){ // 如果右半部分元素已经全部处理完毕，下一个应该是左半部分的元素
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

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(1000000, 0, 1000000);
        SortTestHelper.testSort("org.xiaoyang.advsort.MergeSort", arr);
    }

}

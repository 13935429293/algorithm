package test;

import org.xiaoyang.helper.SortTestHelper;

import java.util.Arrays;

public class InsertionSortTest {

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10000, 0, 10000);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("test.InsertionSortTest", arr);
        SortTestHelper.testSort("test.SelectionSortTest", arr1);
        SortTestHelper.printArray(arr);
        SortTestHelper.printArray(arr1);
    }

    public static void sort(Comparable[] arr){
        for (int i = 1; i < arr.length; i++) {
            Comparable e = arr[i]; // 当前处理的元素
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

}

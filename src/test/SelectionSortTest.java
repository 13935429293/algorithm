package test;

import org.xiaoyang.helper.SortTestHelper;

/**
 * 选择排序，选出最小(大)的放到指定的位置
 */
public class SelectionSortTest {

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10000, 0, 10000);
        SelectionSortTest.sort(arr);
        SortTestHelper.testSort("test.SelectionSortTest", arr);
    }

    public static void sort(Comparable[] arr){
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            SortTestHelper.swap(arr, i, minIndex);
        }
    }

}

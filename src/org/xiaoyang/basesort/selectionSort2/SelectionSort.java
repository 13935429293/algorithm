package org.xiaoyang.basesort.selectionSort2;

import org.xiaoyang.helper.SortTestHelper;

/**
 * 排序所有实现了比较器的对象
 */
public class SelectionSort {

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 寻找[i, n)区间里的最小值的索引
            less(arr, i, minIndex);
        }
    }

    private static void less(Comparable[] arr, int i, int minIndex) {
        for (int j = i + 1; j < arr.length; j++) {
            // 使用compareTo方法比较两个Comparable对象的大小
            if (arr[j].compareTo(arr[minIndex]) < 0)
                minIndex = j;
        }
        swap(arr, i, minIndex);
    }


    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        //Student[] d = new Student[4];
        //d[0] = new Student("D", 90);
        //d[1] = new Student("C", 100);
        //d[2] = new Student("B", 95);
        //d[3] = new Student("A", 95);
        //SelectionSort.sort(d);
        //for (int i = 0; i < d.length; i++)
        //    System.out.println(d[i]);

        Integer[] arr = SortTestHelper.generateRandomArray(1000, 0, 1000000);
        //SelectionSort.sort(arr);
        //SortTestHelper.printArray(arr);

        SortTestHelper.testSort("org.xiaoyang.basesort.selectionSort2.SelectionSort", arr);
    }
}

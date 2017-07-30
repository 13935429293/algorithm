package org.xiaoyang.helper;

import java.lang.reflect.Method;

/**
 * 排序测试工具类
 */
public class SortTestHelper {

    private SortTestHelper(){}

    /**
     * 生成随机数，范围[rangeL, rangeR]
     *
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        Integer[] result = new Integer[n];
        for (int i = 0; i < n; i++)
            result[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        return result;
    }

    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes){

        Integer[] arr = new Integer[n];
        for( int i = 0 ; i < n ; i ++ )
            arr[i] = new Integer(i);

        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    /**
     * 打印数组，须有 toString()
     *
     * @param arr
     */
    public static void printArray(Object arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 是否排序正确
     *
     * @param arr
     * @return
     */
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;
        return true;
    }

    /**
     * 测试排序时间
     *
     * @param sortClassName
     * @param arr
     */
    public static void testSort(String sortClassName, Comparable[] arr) {

        try {
            Class clazz = Class.forName(sortClassName);
            Method method = clazz.getMethod("sort", Comparable[].class);
            Object[] params = new Object[]{arr};

            long start = System.currentTimeMillis();
            method.invoke(null, params);
            long end = System.currentTimeMillis();

            System.out.println(isSorted(arr) ? sortClassName  + " cost time is " + (end - start) + " ms." : "sort error!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试排序时间
     *
     * @param sortClassName
     * @param arr
     */
    public static void testSort(String sortClassName, String methodName, Comparable[] arr) {

        try {
            Class clazz = Class.forName(sortClassName);
            Method method = clazz.getMethod(methodName, Comparable[].class);
            Object[] params = new Object[]{arr};

            long start = System.currentTimeMillis();
            method.invoke(null, params);
            long end = System.currentTimeMillis();

            System.out.println(isSorted(arr) ? sortClassName + "#" + methodName + " cost time is " + (end - start) + " ms." : "sort error!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

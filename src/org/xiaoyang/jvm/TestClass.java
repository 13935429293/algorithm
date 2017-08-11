package org.xiaoyang.jvm;

import java.lang.Exception;

public class TestClass {

    public int inc() {
        int x;
        try {
            x = 1;
            int a = 1/0;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

    public static void main(String[] args) {
        TestClass t = new TestClass();
        System.out.print(t.inc());
    }
}
package org.xiaoyang.jvm;

public class StringEquals {
    public static void main(String[] args) {

        String chinese1 = "你";
        String chinese2 = "你";
        String chinese3 = "我";

        if ("馆".equals("馆")) {
            System.out.println("equal");
        } else {
            System.out.println("no");
        }

        if (chinese1 == chinese3) {
            System.out.println("equal");
        } else {
            System.out.println("no");
        }

    }
}

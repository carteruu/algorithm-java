package com.carter;

import java.util.*;

public class ListThrough {
    public static void main(String[] args) {
        int len = 1000000;
        List<Integer> arr = new ArrayList<>(len);
        List<Integer> link = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            Integer e = new Random().nextInt();
            arr.add(e);
            link.add(e);
        }

//        System.out.println("数组删除值耗时:" + removeValue(arr));
//        System.out.println("链表删除值耗时:" + removeValue(link));

        System.out.println("数组遍历耗时:" + through(arr));
//        System.out.println("链表遍历耗时:" + through(link));

        System.out.println("数组随机访问遍历耗时:" + throughArr(arr));
//        System.out.println("链表迭代器遍历耗时:" + throughLink(link));
    }

    private static int times = 10000;

    private static long removeValue(List<?> list) {
        long arrStart = System.currentTimeMillis();
        Object a = 4;
        for (int i = 0; i < times; i++) {
            list.remove(a);
        }
        return System.currentTimeMillis() - arrStart;
    }

    private static long through(List<Integer> list) {
        long arrStart = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            for (Integer value : list) {
                value += 1;
            }
        }
        return System.currentTimeMillis() - arrStart;
    }

    private static long throughLink(List<Integer> link) {
        long arrStart = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            Iterator<Integer> linkIt = link.iterator();
            while (linkIt.hasNext()) {
                linkIt.next();
            }
        }
        return System.currentTimeMillis() - arrStart;
    }

    private static long throughArr(List<Integer> arr) {
        long arrStart = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < arr.size(); j++) {
                Integer value = arr.get(i);
                value += 1;
            }
        }
        return System.currentTimeMillis() - arrStart;
    }
}

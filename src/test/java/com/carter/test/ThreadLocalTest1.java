package com.carter.test;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class ThreadLocalTest1 {
    @Test
    void test1() {
        Thread thread = new Thread(() -> {
            ThreadLocal<String> l = new ThreadLocal<>();
            String value = "aaa";
            l.set(value);
            MatcherAssert.assertThat(l.get(), Matchers.is(value));
            byte[] g = new byte[1024 * 1024 * 50];
            g[0] = 1;
            System.out.println(g[0]);
            g = null;
            System.gc();
            Runtime.getRuntime().runFinalization();
            System.gc();
            MatcherAssert.assertThat(l.get(), Matchers.nullValue());

            Thread t = Thread.currentThread();
        });
        thread.start();
    }

    @Test
    void test2() {
        ThreadLocal tl = new MyThreadLocal();
        tl.set(new My50MB());

        tl = null;

        System.out.println("GC");
        System.gc();

        for (int i = 0; i < 10; i++) {
            ThreadLocal tl1 = new ThreadLocal();
            tl1.set(11);
            tl1.remove();
        }
    }

    public static class MyThreadLocal extends ThreadLocal {
        private byte[] a = new byte[1024 * 1024 * 1];

        @Override
        public void finalize() {
            System.out.println("My threadlocal 1 MB finalized.");
        }
    }

    public static class My50MB {
        private byte[] a = new byte[1024 * 1024 * 50];

        @Override
        public void finalize() {
            System.out.println("My 50 MB finalized.");
        }
    }
}

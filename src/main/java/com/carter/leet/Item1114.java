package com.carter.leet;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Item1114 {


}

class Foo {
    private final CountDownLatch first;
    private final CountDownLatch second;

    public Foo() {
        this.first = new CountDownLatch(1);
        this.second = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        second.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

class Foo1 {
    private final AtomicInteger step;

    public Foo1() {
        this.step = new AtomicInteger(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        if (step.get() != 0) {
            return;
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        step.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (step.get() < 1) {

        }
        if (step.get() > 1) {
            return;
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        step.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (step.get() < 2) {

        }
        if (step.get() > 2) {
            return;
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        step.incrementAndGet();
    }
}

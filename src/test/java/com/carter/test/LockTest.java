package com.carter.test;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {
    private ReentrantReadWriteLock readWriteLock;
    private ReentrantReadWriteLock.WriteLock writeLock;
    private ReentrantReadWriteLock.ReadLock readLock;

    @BeforeEach
    void beforeEach() {
        readWriteLock = new ReentrantReadWriteLock();
        writeLock = readWriteLock.writeLock();
        readLock = readWriteLock.readLock();
    }

    /**
     * 单线程:先写锁,再读锁
     */
    @Test
    void test() {
        writeLock.lock();
        readLock.lock();
        MatcherAssert.assertThat("单线程:先写锁,再读锁", true);
    }

    /**
     * 单线程:先写锁,再读锁,再写锁
     */
    @Test
    void test1() {
        writeLock.lock();
        readLock.lock();
        writeLock.lock();
        MatcherAssert.assertThat("单线程:先写锁,再读锁,再写锁", true);
    }

    /**
     * 单线程:先读锁,再写锁
     * 不能通过测试
     */
    @Test
    void test2() {
        readLock.lock();
        boolean isLock;
        try {
            isLock = writeLock.tryLock(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            return;
        }
        MatcherAssert.assertThat("单线程:先读锁,不能再写锁", !isLock);
    }
}

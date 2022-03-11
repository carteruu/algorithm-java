package com.carter;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * 子类必须完全一致的方法签名,才会调用子类方法
 * 自动类型转换发生在静态分派中,编译期,重载
 */
class DispatchTest {
    /**
     * 完全一致
     * 子类重写了say(Long i)方法,所以调用子类方法
     */
    @Test
    void test() {
        Dispatch.Parent guy = new Dispatch.Son();
        String rt = guy.say(Long.valueOf(1));
        MatcherAssert.assertThat(rt, Matchers.is("son:Long 1"));
    }

    /**
     * 编译不通过,因为parent没有 say(String) 方法,或可以自动转换类型的方法
     */
    @Test
    void test4() {
        Dispatch.Parent guy = new Dispatch.Son();
//        String rt = guy.say("s");
    }

    /**
     * 子类没有say(long i)方法
     */
    @Test
    void test3() {
        Dispatch.Parent guy = new Dispatch.Son();
        String rt = guy.say(1L);
        MatcherAssert.assertThat(rt, Matchers.is("parent:long 1"));
    }

    /**
     * 子类没有say(Integer i)方法
     * Integer先自动拆箱成int,再转换为long,调用say(long i)方法
     * Integer不能自动转Long
     */
    @Test
    void test2() {
        Dispatch.Parent guy = new Dispatch.Son();
        String rt = guy.say(Integer.valueOf(1));
        MatcherAssert.assertThat(rt, Matchers.is("parent:long 1"));
    }

    /**
     * 子类没有say(int i)方法
     */
    @Test
    void test1() {
        Dispatch.Parent guy = new Dispatch.Son();
        String rt = guy.say(1);
        MatcherAssert.assertThat(rt, Matchers.is("parent:long 1"));
    }


}
package com.carter;

/**
 * 分派
 */
public class Dispatch {
    public static class Parent {
        public String say(Long i) {
            return "parent:Long " + i;
        }

        public String say(long i) {
            return "parent:long " + i;
        }
    }

    public static class Son extends Parent {

        @Override
        public String say(Long i) {
            return "son:Long " + i;
        }

        public String say(int i) {
            return "son:int " + i;
        }

        public String say(String s) {
            return "son:int " + s;
        }
    }
}

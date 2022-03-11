package com.carter.leet;

import com.carter.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Item341 {

    public static class NestedIterator implements Iterator<Integer> {
        private final Iterator<Integer> it;

        public NestedIterator(List<NestedInteger> nestedList) {
            List<Integer> list = new ArrayList<>();
            helper(nestedList, list);
            it = list.iterator();
        }

        private void helper(List<NestedInteger> nestedList, List<Integer> list) {
            if (nestedList == null) {
                return;
            }
            for (NestedInteger nestedIterator : nestedList) {
                if (nestedIterator.isInteger()) {
                    list.add(nestedIterator.getInteger());
                    continue;
                }
                helper(nestedIterator.getList(), list);
            }
        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }
    }
}

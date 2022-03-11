package com.carter.leet;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * * 示例 1：
 * * <p>
 * * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * * 输出："the cat was rat by the bat"
 * * 示例 2：
 * * <p>
 * * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * * 输出："a a b c"
 * * 示例 3：
 * * <p>
 * * 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
 * * 输出："a a a a a a a a bbb baba a"
 * * 示例 4：
 * * <p>
 * * 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * * 输出："the cat was rat by the bat"
 * * 示例 5：
 * * <p>
 * * 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
 * * 输出："it is ab that this solution is ac"
 */
class Item648Test {

    @Test
    void replaceWords() {
        String rs = new Item648().replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery");
        MatcherAssert.assertThat(rs, Matchers.is("the cat was rat by the bat"));
    }
}
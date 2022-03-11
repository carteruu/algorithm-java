package com.carter.leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 * <p>
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 * 示例 3：
 * <p>
 * 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
 * 输出："a a a a a a a a bbb baba a"
 * 示例 4：
 * <p>
 * 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 5：
 * <p>
 * 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
 * 输出："it is ab that this solution is ac"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence 没有前导或尾随空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Item648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node(false);
        dictionary.forEach(dict -> {
            Node node = root;
            char[] charArray = dict.toCharArray();
            for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
                char c = charArray[i];
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Node(false);
                }
                if (i == charArrayLength - 1) {
                    node.children[idx].isLeaf = true;
                }
                node = node.children[idx];
            }
        });
        return Arrays.stream(sentence.split(" "))
                .map(str -> {
                    Node node = root;
                    char[] charArray = str.toCharArray();
                    for (int i = 0; i < charArray.length; i++) {
                        node = node.children[charArray[i] - 'a'];
                        if (node == null) {
                            return str;
                        }
                        if (node.isLeaf) {
                            return str.substring(0, i + 1);
                        }
                    }
                    return str;
                })
                .collect(Collectors.joining(" "));
    }

    public String replaceWords1(List<String> dictionary, String sentence) {
        dictionary.sort(Comparator.comparingInt(String::length));

        return Arrays.stream(sentence.split(" "))
                .map(str -> dictionary.stream()
                        .filter(str::startsWith)
                        .findFirst()
                        .orElse(str))
                .collect(Collectors.joining(" "));
    }

    private static class Node {
        public Node(boolean isLeaf) {
            this.isLeaf = isLeaf;
            children = new Node[26];
        }

        public boolean isLeaf;
        public Node[] children;
    }
}

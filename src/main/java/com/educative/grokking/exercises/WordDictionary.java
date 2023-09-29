package com.educative.grokking.exercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/design-add-and-search-words-data-structure
public class WordDictionary {

    static class Trie {
        Trie[] childs = new Trie[26];
        String word = null;
    }

    private final Trie root = new Trie();

    public WordDictionary() {
    }

    public void addWord(String word) {
        var node = root;
        for (int i = 0; i < word.length(); i++) {
            var charIdx = word.charAt(i) - 'a';
            if (node.childs[charIdx] == null) {
                node.childs[charIdx] = new Trie();
            }
            if (i == word.length() - 1) {
                node.childs[charIdx].word = word;
            }
            node = node.childs[charIdx];
        }
    }

    private boolean searchDfs(int idx, String word, Trie node) {
        if (node == null) {
            return false;
        }
        if (idx == word.length() - 1) {
            if (word.charAt(idx) == '.') {
                for (int i = 0; i < node.childs.length; i++) {
                    if (node.childs[i] != null && node.childs[i].word != null) {
                        return true;
                    }
                }
                return false;
            } else {
                var child = node.childs[word.charAt(idx) - 'a'];
                return child != null && child.word != null;
            }
        } else {
            if (word.charAt(idx) == '.') {
                for (int i = 0; i < node.childs.length; i++) {
                    if (node.childs[i] != null) {
                        var found = searchDfs(idx + 1, word, node.childs[i]);
                        if (found) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                return searchDfs(idx + 1, word, node.childs[word.charAt(idx) - 'a']);
            }
        }
    }

    public boolean search(String word) {
        return searchDfs(0, word, root);
    }

    public List<String> getWords() {
        var res = new ArrayList<String>();
        var stack = new ArrayDeque<Trie>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            var node = stack.pollLast();
            if (node.word != null) {
                res.add(node.word);
            }
            for (char i = 'z'; i >= 'a'; i--) {
                var idx = i - 'a';
                if (node.childs[idx] != null) {
                    stack.offerLast(node.childs[idx]);
                }
            }
        }
        return res;
    }
}

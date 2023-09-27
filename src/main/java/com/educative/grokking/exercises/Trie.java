package com.educative.grokking.exercises;

import com.educative.grokking.templates.TreeNode;
import com.educative.grokking.templates.TrieNode;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        // Write your code here
    }

    // inserting string in trie
    public void insert(String word) {
        var node = root;
        for (int i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            var childNode = node.children.get(c);
            if (i == word.length() - 1) {
                childNode.isWord = true;
            }
            node = childNode;
        }
    }

    // searching for a string
    public boolean search(String word) {
        var node = root;
        for (int i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                return false;
            }
            var childNode = node.children.get(c);
            if (i == word.length() - 1) {
                return childNode.isWord;
            }
            node = childNode;
        }
        return false;
    }

    // searching for a prefix
    public boolean searchPrefix(String prefix) {
        var node = root;
        for (int i = 0; i < prefix.length(); i++) {
            var c = prefix.charAt(i);
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}

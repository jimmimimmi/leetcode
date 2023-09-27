package com.educative.grokking.templates;

import java.util.HashMap;

public class TrieNode {
    public boolean isWord;
    public HashMap<Character, TrieNode> children;

    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        this.isWord = false;
    }
}

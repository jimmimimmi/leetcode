package com.educative.grokking.exercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/replace-words/
public class ReplaceWords {
    static class Trie {
        Trie[] childs = new Trie[26];
        ArrayList<Integer> wordIdx = new ArrayList<>();
        String replace = null;
    }

    private static void replaceDfs(String word, Trie node) {
        if (node == null) return;
        if (node.wordIdx.size() != 0) {
            if (node.replace == null || node.replace.length() > word.length()) {
                node.replace = word;
            }
        }
        for (int i = 0; i < node.childs.length; i++) {
            if (node.childs[i] != null) {
                replaceDfs(word, node.childs[i]);
            }
        }
    }

    private static void replace(String word, Trie root) {
        var node = root;
        var i = 0;
        for (i = 0; i < word.length(); i++) {
            var child = node.childs[word.charAt(i) - 'a'];
            if (child == null) return;
            node = child;
        }

        replaceDfs(word, node);
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        var sentenceWords = sentence.split(" ");

        var root = new Trie();
        for (int i = 0; i < sentenceWords.length; i++) {
            var node = root;
            var word = sentenceWords[i];
            for (int j = 0; j < word.length(); j++) {
                var childIdx = word.charAt(j) - 'a';
                if (node.childs[childIdx] == null) {
                    node.childs[childIdx] = new Trie();
                }
                if (j == word.length() - 1) {
                    node.childs[childIdx].wordIdx.add(i);
                }
                node = node.childs[childIdx];
            }
        }

        for (int i = 0; i < dictionary.size(); i++) {
            var word = dictionary.get(i);
            replace(word, root);
        }

        var queue = new ArrayDeque<Trie>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (node.replace != null) {
                node.wordIdx.forEach(wordId -> sentenceWords[wordId] = node.replace);
            }
            for (int i = 0; i < node.childs.length; i++) {
                if (node.childs[i] != null) {
                    queue.add(node.childs[i]);
                }
            }
        }

        var stringBuilder = new StringBuilder();
        for (int i = 0; i < sentenceWords.length; i++) {
            if (i > 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(sentenceWords[i]);
        }

        return stringBuilder.toString();
    }
}

package com.educative.grokking.exercises;

import java.util.*;

// https://leetcode.com/problems/search-suggestions-system/editorial/
public class SearchSuggestion {
    static class Node {
        Node[] child = new Node[26];
        String word;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        var root = new Node();
        for (var product : products) {
            var node = root;
            for (int j = 0; j < product.length(); j++) {
                var c = product.charAt(j) - 'a';
                if (node.child[c] == null) {
                    node.child[c] = new Node();
                }

                if (j == product.length() - 1) {
                    node.child[c].word = product;
                }
                node = node.child[c];
            }
        }
        // O(N) N - amount of characters in products array

        var result = new ArrayList<List<String>>();
        for (int i = 0; i < searchWord.length(); i++) {
            var subRes = explore(root, searchWord.substring(0, i + 1));
            result.add(subRes);
        }

        // O(K*N)

        return result;
    }

    private static List<String> explore(Node node, String prefix) {
        var currNode = node;
        for (int i = 0; i < prefix.length(); i++) {
            var charIdx = prefix.charAt(i) - 'a';
            var child = currNode.child[charIdx];
            if (child == null) {
                return new ArrayList<>();
            }
            currNode = child;
        }

        var result = new ArrayList<String>();
        var queue = new Stack<Node>();
        queue.add(currNode);
        while (!queue.isEmpty()) {
            currNode = queue.pop();
            if (currNode.word != null) {
                result.add(currNode.word);
                if (result.size() == 3) {
                    return result;
                }
            }
            for (int i = currNode.child.length - 1; i >= 0; i--) {
                if (currNode.child[i] != null) {
                    queue.push(currNode.child[i]);
                }
            }
        }

        return result;
    }


}

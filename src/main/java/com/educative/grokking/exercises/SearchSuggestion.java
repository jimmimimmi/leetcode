package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/search-suggestions-system/editorial/
public class SearchSuggestion {
    class Node {
        Node[] child = new Node[26];
        LinkedList<String> searchWords = new LinkedList<>();
        boolean isWord;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        /*
        products = [“carpet”, “cart”, “car”, “camera”, “crate”]

        searched word = “camera”

                                              c
                                 a                            r
                    m              r                          a
                    e            p    t                        t
                    r            e                              e
                    a            t
         */


        var root = new Node();
        Arrays.sort(products);
        for (var product : products) {
            var node = root;
            for (int j = 0; j < product.length(); j++) {
                var c = product.charAt(j) - 'a';
                if (node.child[c] == null) {
                    node.child[c] = new Node();
                }
                node = node.child[c];
                if (j == product.length() - 1) {
                    node.isWord = true;
                    node.searchWords.add(product.substring(0, j + 1));
                }
            }
        }

        var result = new ArrayList<List<String>>();
        for (int i = 0; i < searchWord.length(); i++) {
            var subRes = new ArrayList<String>();
            explore(root, searchWord.substring(0, i + 1), 0, subRes);
            result.add(subRes);
        }

        return result;
    }

    private static void explore(Node node, String prefix, int prefixIdx, ArrayList<String> result) {
        if (result.size() == 3) {
            return;
        }
        if (prefixIdx >= prefix.length()){
            for (int i = 0; i < node.child.length; i++) {
                if (node.child[i] != null){
                    if (node.child[i].searchWords.peekFirst() != null){
                        if (result.size() == 3) {
                            return;
                        }
                        result.add(node.child[i].searchWords.peekFirst());
                        if (result.size() == 3) {
                            return;
                        }
                    }
                    explore(node.child[i], prefix, prefixIdx, result);
                }
            }
            return;
        }

        var child = node.child[prefix.charAt(prefixIdx) - 'a'];
        if (child == null) return;
        if (child.isWord) {
            result.add(prefix.substring(0, prefixIdx + 1));
            if (result.size() == 3) {
                return;
            }
        }
        explore(child, prefix, prefixIdx + 1, result);
    }
}

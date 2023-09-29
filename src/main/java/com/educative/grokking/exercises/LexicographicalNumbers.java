package com.educative.grokking.exercises;

import java.util.*;

// https://leetcode.com/problems/lexicographical-numbers/submissions/
public class LexicographicalNumbers {
    static class Trie {
        Trie[] childs = new Trie[10];
        Integer word = null;
    }

    private static void dfs(Trie node, List<Integer> result){
        if (node == null) {
            return;
        }
        if (node.word != null) {
            result.add(node.word);
        }
        for(var child: node.childs){
            dfs(child, result);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        var root = new Trie();

        for(Integer i = 1; i <= n; i++){
            var arr = new ArrayList<Integer>();
            var a = i;
            while (a > 0) {
                arr.add(a % 10);
                a = a / 10;
            }

            var node = root;
            for(var j = arr.size() - 1; j >= 0; j--){
                var child = node.childs[arr.get(j)];
                if (child == null){
                    child = new Trie();
                    node.childs[arr.get(j)] = child;
                }
                if (j == 0){
                    child.word=i;
                }
                node = child;
            }
        }

        var res = new ArrayList<Integer>();
        dfs(root, res);

        return res;
    }
}

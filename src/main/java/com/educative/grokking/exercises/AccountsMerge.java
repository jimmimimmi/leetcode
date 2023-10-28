package com.educative.grokking.exercises;

import java.util.*;

// https://leetcode.com/problems/accounts-merge/
public class AccountsMerge {
    private static int findParent(int s, Map<Integer, Integer> parents) {
        parents.putIfAbsent(s, s);

        if (!parents.get(s).equals(s)) {
            parents.put(s, findParent(parents.get(s), parents));
        }
        return parents.get(s);
    }

    private static void union(int a, int b, Map<Integer, Integer> parents, Map<Integer, Integer> ranks) {
        var parA = findParent(a, parents);
        var parB = findParent(b, parents);
        if (parA == parB) {
            return;
        }

        ranks.putIfAbsent(parA, 1);
        ranks.putIfAbsent(parB, 1);

        var newRank = ranks.get(parA) + ranks.get(parB);
        if (ranks.get(parA) >= ranks.get(parB)) {
            parents.put(parB, parA);
            ranks.put(parA, newRank);
        } else {
            parents.put(parA, parB);
            ranks.put(parB, newRank);
        }
    }


    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        var parents = new LinkedHashMap<Integer, Integer>();
        var ranks = new HashMap<Integer, Integer>();
        var emailToAcc = new HashMap<String, Integer>();

        for (int rowIdx = 0; rowIdx < accounts.size(); rowIdx++) {
            List<String> row = accounts.get(rowIdx);
            for (int i = 1; i < row.size(); i++) {
                var email = row.get(i);
                if (emailToAcc.containsKey(email)) {
                    union(rowIdx, emailToAcc.get(email), parents, ranks);
                } else {
                    emailToAcc.put(email, rowIdx);
                }
            }
        }

        for (var p : parents.entrySet()) {
            findParent(p.getKey(), parents);
        }

        var parentToFirstChildIdx = new HashMap<Integer, Integer>();


        var result = new HashMap<Integer, HashSet<String>>();


        for (int rowIdx = 0; rowIdx < accounts.size(); rowIdx++) {
            var row = accounts.get(rowIdx);
            var parent = findParent(rowIdx, parents);
            if (!parentToFirstChildIdx.containsKey(parent)) {
                parentToFirstChildIdx.put(parent, rowIdx);
                result.put(rowIdx, new HashSet<>());
            }
            for (int i = 1; i < row.size(); i++) {
                result.get(parentToFirstChildIdx.get(parent)).add(row.get(i));
            }
        }

        var r = new ArrayList<List<String>>();
        for (int rowIdx = 0; rowIdx < accounts.size(); rowIdx++) {
            var row = accounts.get(rowIdx);
            var parent = findParent(rowIdx, parents);
            if (parentToFirstChildIdx.containsKey(parent)) {
                var emailList = new ArrayList<>(result.get(parentToFirstChildIdx.get(parent)));
                Collections.sort(emailList);
                var finalRow = new ArrayList<String>();
                finalRow.add(row.get(0));
                finalRow.addAll(emailList);
                r.add(finalRow);
                parentToFirstChildIdx.remove(parent);
            }

        }

        return r;
    }
}

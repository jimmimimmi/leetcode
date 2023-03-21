package com.jimmimimmi.java.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SameTree_iterative {

    private boolean areSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        var queue = new ArrayDeque<TreeNode[]>();
        queue.push(new TreeNode[]{p, q});
        while (!queue.isEmpty()) {
            var pop = queue.pop();
            if (!areSame(pop[0], pop[1])) return false;
            if (pop[0] != null) {
                queue.push(new TreeNode[]{pop[0].left, pop[1].left});
                queue.push(new TreeNode[]{pop[0].right, pop[1].right});
            }
        }
        return true;
    }
}

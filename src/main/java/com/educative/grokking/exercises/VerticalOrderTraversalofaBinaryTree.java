package com.educative.grokking.exercises;

import com.jimmimimmi.java.trees.TreeNode;

import java.util.*;
public class VerticalOrderTraversalofaBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        var minBucket = 0;
        var maxBucket = 0;

        var queue = new ArrayDeque<TreeNode>();
        var queueBuckets = new ArrayDeque<Integer>();
        var depthQueue = new ArrayDeque<Integer>();
        var buckets = new HashMap<Integer, TreeMap<Integer, List<Integer>>>();

        queue.offer(root);
        queueBuckets.offer(0);
        depthQueue.offer(0);
        while(!queue.isEmpty()) {

            var size = queue.size();
            for(var i = 0; i < size; i++){
                var node = queue.poll();
                var bucket = queueBuckets.poll();
                var depth = depthQueue.poll();
                if (!buckets.containsKey(bucket)){
                    buckets.put(bucket, new TreeMap<>());
                }
                var depthMap = buckets.get(bucket);
                if (!depthMap.containsKey(depth)){
                    depthMap.put(depth, new ArrayList<>());
                }
                depthMap.get(depth).add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                    queueBuckets.offer(bucket - 1);
                    depthQueue.offer(depth + 1);
                }

                if (node.right != null){
                    queue.offer(node.right);
                    queueBuckets.offer(bucket + 1);
                    depthQueue.offer(depth + 1);
                }

                minBucket = Math.min(minBucket, bucket);
                maxBucket = Math.max(maxBucket, bucket);

            }

        }


        for(var i = minBucket; i<= maxBucket; i++) {
            var depthMap = buckets.get(i);
            var subResult = new ArrayList<Integer>();
            depthMap.forEach((depth, values) -> {
                values.sort(Integer::compareTo);
                subResult.addAll(values);
            });

            result.add(subResult);
        }



        return result;
    }
}

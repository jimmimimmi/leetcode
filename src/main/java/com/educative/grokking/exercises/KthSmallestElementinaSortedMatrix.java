package com.educative.grokking.exercises;


import java.util.Comparator;
import java.util.PriorityQueue;

/*
Find the kth  smallest element in an (n×n) matrix,
where each row and column of the matrix is sorted in ascending order.

Although there can be repeating values in the matrix,
each element is considered unique and, therefore, contributes to calculating the kth smallest element.

*/
public class KthSmallestElementinaSortedMatrix {
    public static int kthSmallestElement(int[][] matrix, int k) {

        var heap = new PriorityQueue<int[]>(Comparator.comparingInt(arr -> arr[0]));
        for (int i = 0; i < matrix.length; i++) {
            heap.offer(new int[]{matrix[i][0], i, 0});
        }
        int currentNum = 0;
        while (!heap.isEmpty()) {
            var head = heap.poll();
            var val = head[0];
            var row = head[1];
            var col = head[2];
            currentNum++;
            if (currentNum == k) {
                return val;
            }
            if (col < matrix[row].length - 1) {
                heap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        return -1;
    }
}

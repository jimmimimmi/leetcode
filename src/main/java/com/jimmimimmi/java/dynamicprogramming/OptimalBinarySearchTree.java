package com.jimmimimmi.java.dynamicprogramming;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/OptimalTreeSearch.java
public class OptimalBinarySearchTree {
    //input is sorted

    private int counter = 0;

    public int getMinCost_recursive(int input[], int freq[]) {
        var result = getMinCost(input, freq, 1, 0, input.length - 1);
        System.out.println("total counter " + counter);
        return result;
    }

    private int getMinCost(int input[], int freq[], int level, int left, int right) {

        counter++;

        if (left > right) {
            return 0;
        }

        if (left == right) {
            return freq[left] * level;
        }

        int min = Integer.MAX_VALUE;
        for (int k = left; k <= right; k++) {
            var leftCost = getMinCost(input, freq, level + 1, left, k - 1);
            var currentCost = freq[k] * level;
            var rightCost = getMinCost(input, freq, level + 1, k + 1, right);

            var totalCost = leftCost + currentCost + rightCost;
            if (min > totalCost) {
                min = totalCost;
            }
        }

        return min;
    }

    public int getMinCost_dp(int input[], int freq[]) {
        var partialCosts = new int[input.length][input.length];
        for (int i = 0; i < input.length; i++) {
            partialCosts[i][i] = freq[i];
        }

        for (int length = 2; length <= input.length; length++) {
            for (int left = 0; left <= input.length - length; left++) {

                var right = left + length - 1;
                var sum = sum(freq, left, right);

                var min = Integer.MAX_VALUE;
                for (int pivot = left; pivot <= right; pivot++) {
                    int leftResult = pivot == left ? 0 : partialCosts[left][pivot - 1];
                    int rightResult = pivot + 1 == left + length ? 0 : partialCosts[pivot + 1][right];
                    int totalResult = leftResult + rightResult;
                    if (min > totalResult) min = totalResult;
                }
                partialCosts[left][right] = sum + min;
            }
        }

        return partialCosts[0][input.length - 1];
    }

    private int sum(int freq[], int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += freq[i];
        }
        return sum;
    }
}

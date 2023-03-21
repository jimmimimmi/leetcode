package com.jimmimimmi.java.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) return new ArrayList<>();
        return explore(buildings, 0, buildings.length - 1);
    }

    private List<List<Integer>> explore(int[][] buildings, int start, int end) {
        if (end < start) return Collections.EMPTY_LIST;
        if (start == end) {
            ArrayList<List<Integer>> r = new ArrayList<>();
            r.add(Arrays.stream(new int[]{buildings[start][0], buildings[start][2]}).boxed().collect(Collectors.toList()));
            r.add(Arrays.stream(new int[]{buildings[start][1], 0}).boxed().collect(Collectors.toList()));
            return r;
        }

        int middle = start + (end - start) / 2;
        var left = explore(buildings, start, middle);
        var right = explore(buildings, middle + 1, end);
        return merge(left, right);
    }

    private List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (left == null && right == null) return result;
        if (left == null) return right;
        if (right == null) return left;

        int leftIdx = 0;
        int rightIdx = 0;

        int leftHeight = 0;
        int rightHeight = 0;
        int currentHeight = 0;

        while (leftIdx < left.size() && rightIdx < right.size()) {
            List<Integer> leftPoint = left.get(leftIdx);
            List<Integer> rightPoint = right.get(rightIdx);

            var currentX = 0;

            if (leftPoint.get(0) < rightPoint.get(0)) {
                currentX = leftPoint.get(0);
                leftHeight = leftPoint.get(1);
                leftIdx++;
            } else {
                currentX = rightPoint.get(0);
                rightHeight = rightPoint.get(1);
                rightIdx++;
            }

            var maxHeight = Math.max(leftHeight, rightHeight);
            if (currentHeight != maxHeight) {
                addResult(result, currentX, maxHeight);
                currentHeight = maxHeight;
            }
        }

        while (leftIdx < left.size()) {
            addResult(result, left.get(leftIdx).get(0), left.get(leftIdx).get(1));
            leftIdx++;
        }

        while (rightIdx < right.size()) {
            addResult(result, right.get(rightIdx).get(0), right.get(rightIdx).get(1));
            rightIdx++;
        }
        return result;
    }

    private void addResult(List<List<Integer>> result, int x, int y) {
        if (result.isEmpty() || result.get(result.size() - 1).get(0) != x)
            result.add(Arrays.stream(new Integer[]{x, y}).collect(Collectors.toList()));
        else result.get(result.size() - 1).set(1, y);
    }
}

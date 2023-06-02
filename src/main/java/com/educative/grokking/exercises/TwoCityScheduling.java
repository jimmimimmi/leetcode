package com.educative.grokking.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
A company is planning to interview 2n people.
You're given the array costs where costs[i]=[aCost i ,bCost i].
 The cost of flying the ith person to city A is aCost i,
 and the cost of flying the ith  person to city B bCost i

Return the minimum cost to fly every person to a city such that exactly
n  people arrive in each city.
 */
public class TwoCityScheduling {
    public static int twoCityScheduling(int[][] costs) {
        var list = Arrays.stream(costs)
                .map(c -> new int[]{c[0] - c[1], c[0], c[1]})
                .sorted(Comparator.comparingInt(o -> o[0]))
                .collect(Collectors.toList());
        var leftPart = IntStream.range(0, costs.length / 2).reduce(0, (left, right) -> left + list.get(right)[1]);
        var rightPart = IntStream.range(costs.length / 2, costs.length).reduce(0, (left, right) -> left + list.get(right)[2]);
        // Write your code here
        return leftPart + rightPart;
    }
}

package com.educative.grokking.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*

There are
�
n
 gas stations along a circular route, where the amount of gas at the
�
�
ℎ
i
th

 station is gas[i].

We have a car with an unlimited gas tank,
and it costs cost[i] of gas to travel from the ith  station to the next (i+1)th station.
We begin the journey with an empty tank at one of the gas stations.

Find the index of the gas station in the integer array gas such that
if we start from that index we may return to the same index by traversing through all the elements,
collecting gas[i] and consuming cost[i].

If it is not possible, return -1.

If there exists a solution, it is guaranteed to be unique.

 */
public class GasStations {
    public static int gasStationJourney(int[] gas, int[] cost) {

        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1;

        var start = 0;
        var accumulatedGas = 0;

        for (int i = 0; i < gas.length; i++) {
            accumulatedGas += (gas[i] - cost[i]);
            if (accumulatedGas  < 0){
                accumulatedGas = 0;
                start = i + 1;
            }
        }
        return start;
    }
}

package com.educative.grokking.exercises;

import java.util.PriorityQueue;

/*
You need to find the minimum number of refueling stops that a car needs to make to cover a distance, target.
For simplicity, assume that the car has to travel from west to east in a straight line.
There are various fuel stations on the way that are represented as a 2-D array of stations,
i.e., stations[i] = [d-i ,f_i ], where

 is the distance (in miles) of the ith
 gas station from the starting position, and
 is the amount of fuel (in liters) that it stores.
 Initially, the car starts with k liters of fuel.
 The car consumes one liter of fuel for every mile traveled. Upon reaching a gas station,
 the car can stop and refuel using all the petrol stored at the station.
 In case it cannot reach the target, the program simply returns

 */
public class MinimumNumberOfRefuelingStops {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {

        var maxHeap = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o2[1], o1[1]));
        var stops = 0;
        var reachableDist = startFuel;
        for (int i = 0; i < stations.length; i++) {
            if (reachableDist >= target) {
                return stops;
            }
            if (reachableDist >= stations[i][0] ) {
                maxHeap.offer(stations[i]);
            } else {
                while (!maxHeap.isEmpty() && reachableDist < stations[i][0]) {
                    var head = maxHeap.poll();
                    reachableDist += head[1];
                    stops++;
                }
                if (reachableDist < stations[i][0]){
                    return -1;
                }
                maxHeap.offer(stations[i]);
            }
        }
        while (!maxHeap.isEmpty() && reachableDist < target) {
            var head = maxHeap.poll();
            reachableDist += head[1];
            stops++;
        }
        if (reachableDist >= target) {
            return stops;
        } else {
            return -1;
        }
    }
}

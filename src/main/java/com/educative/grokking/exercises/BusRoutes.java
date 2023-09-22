package com.educative.grokking.exercises;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/bus-routes/description/

public class BusRoutes {
    public static int minimumBuses(int[][] routes, int source, int target) {

        if (source == target) {
            return 0;
        }

        if (routes == null || routes.length == 0) {
            return -1;
        }

        var busStopToBusNumbers = new HashMap<Integer, ArrayList<Integer>>();

        for (var busNumber = 0; busNumber < routes.length; busNumber++) {
            var busRoute = routes[busNumber];
            var busStops = Arrays.stream(busRoute).boxed().collect(Collectors.toList());
            for (var busStop : busStops) {
                if (!busStopToBusNumbers.containsKey(busStop)) {
                    busStopToBusNumbers.put(busStop, new ArrayList<>());
                }
                busStopToBusNumbers.get(busStop).add(busNumber);
            }
        }

        var visitedBuses = new HashSet<Integer>();
        var stationsQueue = new ArrayDeque<Integer>();
        var depthQueue = new ArrayDeque<Integer>();

        stationsQueue.add(source);
        depthQueue.add(0);

        while (!stationsQueue.isEmpty()){
            var station = stationsQueue.poll();
            var depth = depthQueue.poll();

            if (station == target){
                return depth;
            }

            var buses = busStopToBusNumbers.get(station);
            if (buses != null){
                for(var bus: buses){
                    if (!visitedBuses.contains(bus)){
                        var stations = routes[bus];
                        for(var s: stations){
                            stationsQueue.add(s);
                            depthQueue.add(depth + 1);
                        }
                        visitedBuses.add(bus);
                    }
                }
            }
        }

        return -1;
    }


}

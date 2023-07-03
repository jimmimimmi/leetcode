package com.educative.grokking.exercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/exclusive-time-of-functions/
public class ExclusiveExecutionTimeofFunctions {
    public static List<Integer> exclusiveTime(int n, List<String> events) {

        var result = IntStream.of(new int[n]).boxed().collect(Collectors.toCollection(ArrayList::new));

        var functionIdStack = new ArrayDeque<Integer>();
        var functionStartStack = new ArrayDeque<Integer>();

        for (var event : events) {
            var split = event.split(":");
            var id = Integer.parseInt(split[0]);
            var time = Integer.parseInt(split[2]);
            if (split[1].equals("start")) {
                functionIdStack.addLast(id);
                functionStartStack.addLast(time);
            } else {
                functionIdStack.removeLast();
                var start = functionStartStack.removeLast();
                var duration = time - start + 1;
                result.set(id, result.get(id) + duration);
                if (!functionIdStack.isEmpty()) {
                    var prevFunctionId = functionIdStack.peekLast();
                    result.set(prevFunctionId, result.get(prevFunctionId) - duration);
                }
            }
        }

        return result;
    }
}

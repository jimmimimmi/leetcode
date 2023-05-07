package com.educative.grokking.exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ScheduleTasksOnMinimumMachines {
    public static int tasks(List<List<Integer>> tasksList) {

        var incomingTasks = new PriorityQueue<List<Integer>>(Comparator.comparing(o -> o.get(0)));
        var processingTasks = new PriorityQueue<List<Integer>>(Comparator.comparing(o -> o.get(1)));

        var maxParallelProcessings = 0;
        for (List<Integer> task : tasksList) {
            incomingTasks.offer(task);
        }

        while (!incomingTasks.isEmpty()) {
            var task = incomingTasks.poll();
            while (!processingTasks.isEmpty() && processingTasks.peek().get(1) < task.get(0)){
                processingTasks.poll();
            }
            processingTasks.offer(task);
            maxParallelProcessings = Math.max(maxParallelProcessings, processingTasks.size());
        }

        return maxParallelProcessings;
    }
}

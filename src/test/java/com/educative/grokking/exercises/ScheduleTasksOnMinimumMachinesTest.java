package com.educative.grokking.exercises;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class ScheduleTasksOnMinimumMachinesTest extends TestCase {

    public void testTasks() {
        // [[1, 7], [8, 13], [5, 6], [10, 14], [6, 7]]
        ScheduleTasksOnMinimumMachines.tasks(Arrays.asList(
                        Arrays.asList(1, 7),
                        Arrays.asList(8, 13),
                        Arrays.asList(5, 6),
                        Arrays.asList(10, 14),
                        Arrays.asList(6, 7)
                )
        );
    }
}
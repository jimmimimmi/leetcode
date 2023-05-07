package com.educative.grokking.exercises;

/*
You need to develop a program for making automatic investment decisions for a busy investor.
The investor has some start-up capital, c,
to invest and a portfolio of projects in which they would like to invest in.
The investor wants to maximize their cumulative capital as a result of this investment.

To help them with their decision,
they have information on the capital requirement for each project and the profit it’s expected to yield.
For example, if project A has a capital requirement of 3, and the investor’s current capital is 1,
then the investor can’t invest in this project.
On the other hand, if the capital requirement of a project B is 1,
then the investor can invest in this project.
Now, supposing that the project yields a profit of 2,
the investor’s capital at the end of the project will be 1+2=3.

The investor can now choose to invest in project A as well since their current capital has increased.
As a basic risk-mitigation measure, the investor would like to set a limit on the number of projects, k,
they invest in.
For example, if the value of k is 2, then we need to identify the two projects that the investor can afford to invest in,
given their capital requirements, and that yield the maximum profits.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeCapital {
    public static int maximumCapital(int initialCapital, int maxProjects, int[] capitals, int[] profits) {
        // min-heap for capitals
        // max-heap for profits

        // poll from capital while can and push into profits
        // if can not poll from capital anymore than poll from profits and update currentCapital
        // repeat polling from capitals again while the end is not achieved

        var currentCapital = initialCapital;
        var totalProjects = 0;

        var capitalsMinQueue = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[0]));
        for (var i = 0; i < capitals.length; i++) {
            capitalsMinQueue.offer(new int[]{capitals[i], i});
        }

        var profitsMaxQueue = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        while (totalProjects < maxProjects) {
            while (!capitalsMinQueue.isEmpty() && capitalsMinQueue.peek()[0] <= currentCapital) {
                var affordableProject = capitalsMinQueue.poll();
                var projectIndex = affordableProject[1];
                profitsMaxQueue.offer(new int[]{profits[projectIndex], projectIndex});
            }

            if (profitsMaxQueue.isEmpty()) {
                break;
            }

            var mostProfitableProjectSoFar = profitsMaxQueue.poll();
            currentCapital += mostProfitableProjectSoFar[0];

            totalProjects++;
        }

        return currentCapital;
    }
}

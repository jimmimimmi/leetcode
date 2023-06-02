package com.educative.grokking.exercises;

import java.util.Arrays;

/*
You’re given an array, people, where people[i] is the weight of the ith person,
and an infinite number of boats, where each boat can carry a maximum weight, limit.

Each boat carries, at most, two people at the same time.
This is provided that the sum of the weight of those people is under or equal to the weight limit.

You need to return the minimum number of boats to carry every person in the array.
 */
public class BoatstoSavePeople {
    public static int rescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        var left = 0;
        var right = people.length - 1;
        var result = 0;

        while (left <= right) {
            if (left == right) {
                result++;
                left++;
                right--;
                continue;
            }

            if (people[left] + people[right] <= limit) {
                result += 2;
                left++;
                right--;
                continue;
            }

            result++;
            right--;
        }
        return result;
    }
}

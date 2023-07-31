package com.educative.grokking.exercises;

import java.util.*;

public class TaskScheduler {
    public static int leastTime(char[] tasks, int n) {

        var freqMap = new HashMap<Character, Integer>();
        for (var task : tasks) {
            var prevFreq = freqMap.getOrDefault(task, 0);
            freqMap.put(task, prevFreq + 1);
        }
        var sortFreq = new ArrayList<>(freqMap.entrySet());
        sortFreq.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        var currIdx = 0;
        var totalTime = 0;
        var windowIndexes = new HashMap<Character, Integer>();
        var res = "";
        while (currIdx < tasks.length) {
            for (Map.Entry<Character, Integer> entry : sortFreq) {
                if (entry.getValue() > 0) {
                    var currChar = entry.getKey();
                    var curCharPrevIdx = windowIndexes.get(currChar);
                    if (curCharPrevIdx != null && curCharPrevIdx >= totalTime + 1 - n) {
                        var newTotalTime = curCharPrevIdx + n + 1;
                        totalTime = Math.max(totalTime + 1, newTotalTime);
                    } else {
                        totalTime = totalTime + 1;
                    }
                    windowIndexes.put(currChar, totalTime);
                    res += currChar;
                    currIdx += 1;
                    entry.setValue(entry.getValue() - 1);
                }
            }
        }

        return totalTime;
    }
}

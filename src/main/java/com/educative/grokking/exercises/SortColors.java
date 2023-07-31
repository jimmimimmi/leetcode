package com.educative.grokking.exercises;

/*
https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors {
    public static int[] sortColors(int[] colors) {

        // 0,1,0  => 0,0,1

        var red = 0;
        var white = 0;
        var blue = colors.length - 1;
        while (white <= blue) {
            if (colors[white] == 0) {
                if (colors[red] != 0) {
                    colors[white] = colors[red];
                    colors[red] = 0;
                }
                red++;
                white++;
            } else if (colors[white] == 1) {
                white++;
            } else {
                if (colors[blue] != 2) {
                    var temp = colors[white];
                    colors[white] = colors[blue];
                    colors[blue] = temp;
                }
                blue--;
            }
        }


        return colors;
    }
}

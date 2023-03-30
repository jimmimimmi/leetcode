package com.educative.grokking.exercises;

/*
Given an array where the element at the index i represents the price of a stock on day i,
find the maximum profit that you can gain by buying the stock once and then selling it.
Note: Stock can only be purchased on a single day and sold on a different day.
If no profit can be achieved, we return zero.

 */
public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] stockPrices) {

        var result = 0;
        var left = 0;
        var right = 1;
        while (right < stockPrices.length) {
            if (stockPrices[right] > stockPrices[left]) {
                result = Math.max(result, stockPrices[right] - stockPrices[left]);
            } else {
                left = right;
            }
            right++;
        }

        return result;
    }
}

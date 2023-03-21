package com.jimmimimmi.java.trees;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

class GridenvSolution {

    public int solution(int X, int[] B, int Z) {
        if (X == 0) return 0;
        if (B.length == 0) return -1;

        var downloadedBytes = Arrays.stream(B).sum();
        if (X == downloadedBytes) return 0;
        var remainingBytes = X - downloadedBytes;

        if (remainingBytes <= 0) return 0;


        var observations = Arrays.stream(B).boxed().collect(Collectors.toList());
        Collections.reverse(observations);
        var sumObservation = observations.stream().limit(Z).mapToInt(Integer::intValue).sum();
        var averageObsrvation = sumObservation / (Z * 1.0d);
        return (int) Math.ceil(remainingBytes / averageObsrvation);

    }


    Integer second = 1;
    Integer minute = second * 60;
    Integer hour = minute * 60;
    Integer day = hour * 24;
    Integer week = day * 7;
    Integer[] divisions = new Integer[]{week, day, hour, minute, second};
    Map<Integer, String> abbreviations = Map.of(week, "w", day, "d", hour, "h", minute, "m", second, "s");


//    public String solution2(int X) {
//
//        var result = new HashMap<Integer, Integer>();
//        doRun(X, result);
//        if (result.keySet().size() <= 2) {
//            AtomicReference<String> resultString = new AtomicReference<>("");
//
//            Arrays.stream(divisions).forEach(d -> {
//                if (result.containsKey(d)) {
//                    var amount = result.get(d);
//                    var abbr = abbreviations.get(d);
//                    resultString.set(resultString + amount.toString() + abbr);
//                }
//            });
//
//            return resultString.get();
//        } else {
//            AtomicInteger total = new AtomicInteger();
//            AtomicReference<String> resultString = new AtomicReference<>("");
//            Arrays.stream(divisions).forEach(d -> {
//                if (result.containsKey(d) && total.get() < 2) {
//                    var amount = result.get(d);
//                    var amountResult = total.get() == 1 ? Integer.valueOf(amount + 1) : amount;
//                    var abbr = abbreviations.get(d);
//                    resultString.set(resultString + amountResult.toString() + abbr);
//                    total.set(total.get() + 1);
//                }
//            });
//
//            return resultString.get();
//        }
//    }

//    private void doRun(int X, Map<Integer, Integer> result) {
//        var firstOpt = Arrays.stream(divisions).filter(d -> d <= X).findFirst();
//        if (firstOpt.isEmpty()) return;
//        var division = firstOpt.get();
//        if (result.containsKey(division)) {
//            var prev = result.get(division);
//            result.put(division, prev + 1);
//        } else {
//            result.put(division, 1);
//        }
//
//        doRun(X - division, result);
//    }
//
//    public String[] solution(String S, String[] B) {
//        var exess = new BigDecimal(S);
//        var invoices = new BigDecimal[B.length];
//
//
//        for (int i = 0; i < B.length; i++) {
//            invoices[i] = new BigDecimal(B[i]);
//        }
//
//
//    }
//
//    private void doRun(BigDecimal remainingExcess, BigDecimal[] remainingInvoices) {
//        if (remainingInvoices.length == 0) return;
//
//        var sum = new BigDecimal(0);
//        var max = remainingInvoices[0];
//        for (BigDecimal remainingInvoice : remainingInvoices) {
//            sum.add(remainingInvoice);
//            max = max.max(remainingInvoice);
//        }
//
//        var result = remainingExcess.multiply(max.divide(sum)).setScale(2, BigDecimal.ROUND_DOWN);
//
//        Arrays.stream(remainingInvoices).fi
//        return doRun(remainingExcess.subtract(result),);
//    }
}

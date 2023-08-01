package com.jimmimimmi.java.trees;

import java.util.HashMap;

public class DecodeWays {

    // 111 -> 1,1,1   1,11   11,1
    // 1 (1,1) => 1 (1 [1])   1(11[])
    // 11(1) => 11(1[]))


    // 1111 -> 1 (111)
    //      -> 11(11)

    /*

    11 -> 1(1), 11()
    1 -> 1()

    1 -> 1()  => 1
    11 -> 1(1)  + 11() => 2
    111 -> 1(11) + 11(1) => 2 + 1 = 3
    1111 -> 1(111) + 11(11) => 3 + 2 = 5

    [4-...] -> 1
    [3-...] -> 1


      1    1    1    1
    1                   1
    1                   1
    1                2  1
    1                1  1
      1    1    1    1  1
     */


    //23  -> 2,3  23    2 (3  (...)
    // 082 -> 0
    // 12345 -> [1,2,3,4,5] [12,3,4,5] [1,23,4,5] [12,34,5]

    // 2345 -> 2 (3,4,5) ->
    //                   -> 3 (4,5)
    //      -> 23 (4,5)
    public static int numOfDecodings(String decodeStr) {
        var res = explore(decodeStr, new HashMap<>(), 0);
        return res == null ? 0 : res;
    }

    public static int numOfDecodingsDp(String decodeStr) {
        var dp = new int[decodeStr.length() + 1];
        dp[decodeStr.length()] = 1;

        for (int i = decodeStr.length() - 1; i >= 0; i--) {
            if (decodeStr.charAt(i) != '0') {
                dp[i] += dp[i + 1];
            }
            if (i + 2 <= decodeStr.length() && decodeStr.charAt(i) != '0') {
                var substring = decodeStr.substring(i, i + 2);
                var parse = Integer.parseInt(substring);
                if (parse <= 26 && parse > 0) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }

    public static Integer explore(String decodeStr, HashMap<Integer, Integer> cache, int idx) {

        if (idx > decodeStr.length()) {
            return 1;
        }
        if (cache.containsKey(idx)) {
            return cache.get(idx);
        }

        Integer explore1 = null;
        Integer explore2 = null;
        if (idx + 1 <= decodeStr.length() && decodeStr.charAt(idx) != '0') {
            explore1 = explore(decodeStr, cache, idx + 1);
        }

        if (idx + 2 <= decodeStr.length() && decodeStr.charAt(idx) != '0') {
            var substring = decodeStr.substring(idx, idx + 2);
            var parse = Integer.parseInt(substring);
            if (parse <= 26 && parse > 0) {
                explore2 = explore(decodeStr, cache, idx + 2);
            }
        }
        if (explore1 == null && explore2 == null) {
            cache.put(idx, null);
            return null;
        }


        var count = 0;
        count += explore1 != null ? explore1 : 0;
        count += explore2 != null ? explore2 : 0;
        cache.put(idx, count);
        return count;
    }


}

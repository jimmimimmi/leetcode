package com.jimmimimmi.java.backtracking;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/restore-ip-addresses/
/*
93. Restore IP Addresses
Medium

Add to List

Share
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> lists = restoreIpAddresses(s, 0, 0);

        ArrayList<String> result = new ArrayList<>();
        lists.forEach(integers ->
                result.add(String.join(".", integers))
        );
        return result;
    }

    public List<List<String>> restoreIpAddresses(String s, int currentIndex, int octetNum) {
        if (currentIndex >= s.length()) return null;
        if (octetNum == 3 && currentIndex < s.length() - 3) {
            return null;
        }

        if (octetNum == 3) {
            String octetString = s.substring(currentIndex);
            int octet = Integer.parseInt(octetString);
            if (octet < 0 || octet > 255 || (octetString.charAt(0) == '0' && octetString.length() > 1)) return null;
            else {
                return new ArrayList<>() {{
                    add(new ArrayList<>() {{
                        add(octetString);
                    }});
                }};
            }
        }

        ArrayList<List<String>> result = new ArrayList<>();

        for (int i = 3; i >= 1; i--) {
            if (currentIndex + i < s.length()) {
                String octetString = s.substring(currentIndex, currentIndex + i);
                if (i != 1 && octetString.charAt(0) == '0') continue;
                var octet = Integer.parseInt(octetString);
                if (octet < 256) {
                    var subResult = restoreIpAddresses(s, currentIndex + i, octetNum + 1);
                    if (subResult != null) {
                        subResult.forEach(integers -> result.add(new ArrayList<>() {{
                            add(octetString);
                            addAll(integers);
                        }}));
                    }
                }
            }
        }

        return result;
    }
}

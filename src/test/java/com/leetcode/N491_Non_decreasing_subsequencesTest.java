package com.leetcode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;

import java.util.List;

public class N491_Non_decreasing_subsequencesTest extends TestCase {

    public void testFindSubsequences() throws JsonProcessingException {
        var objectMapper = new ObjectMapper();
        var sub = new N491_Non_decreasing_subsequences();
        var res1 = sub.findSubsequences(new int[]{4, 6, 7, 7});
        System.out.println(objectMapper.writeValueAsString(res1));
    }
}
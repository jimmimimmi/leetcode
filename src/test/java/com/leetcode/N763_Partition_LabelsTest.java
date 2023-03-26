package com.leetcode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;

public class N763_Partition_LabelsTest extends TestCase {

    public void testPartitionLabels() throws JsonProcessingException {
//        System.out.println(new ObjectMapper().writeValueAsString("res: " + N763_Partition_Labels.partitionLabels("ababcbacadefegdehijhklij")));
        System.out.println(new ObjectMapper().writeValueAsString("res: " + N763_Partition_Labels.partitionLabels("eaaaabaaec")));
    }
}
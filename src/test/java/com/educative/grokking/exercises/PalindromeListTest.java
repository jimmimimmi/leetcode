package com.educative.grokking.exercises;

import com.educative.grokking.templates.LinkedList;
import com.educative.grokking.templates.LinkedListTraversal;
import junit.framework.TestCase;

public class PalindromeListTest extends TestCase {

    public void testPalindrome() {
        var linkedList = LinkedList.createLinkedList(new Integer[]{1, 2, 3, 2, 1});
        PalindromeList.palindrome(linkedList.head);
    }
}
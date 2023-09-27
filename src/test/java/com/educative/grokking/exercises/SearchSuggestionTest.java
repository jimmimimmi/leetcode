package com.educative.grokking.exercises;

import junit.framework.TestCase;

public class SearchSuggestionTest extends TestCase {

    public void testSuggestedProducts() {
        new SearchSuggestion().suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse").forEach(list -> {
            System.out.println(list);
        });
    }
}
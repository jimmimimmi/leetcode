package com.educative.grokking.exercises;

import junit.framework.TestCase;

public class RegionsCutBySlashesTest extends TestCase {

    public void testRegionsBySlashes() {
        new RegionsCutBySlashes().regionsBySlashes(new String[]{"/\\","\\/"});
    }
}
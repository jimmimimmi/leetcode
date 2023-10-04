package com.educative.grokking.exercises;

import java.util.ArrayList;

// https://leetcode.com/problems/design-hashmap/description/
public class MyHashMap {
    class Bucket {

        private final ArrayList<int[]> values = new ArrayList<>();

        // put value in bucket
        public void update(int key, int value) {
            var ok = false;
            for (int[] ints : values) {
                if (ints[0] == key) {
                    ints[1] = value;
                    ok = true;
                    break;
                }
            }

            if (!ok) {
                values.add(new int[]{key, value});
            }
        }

        // get value from bucket
        public int get(int key) {
            for (int[] value : values) {
                if (value[0] == key) {
                    return value[1];
                }
            }
            return -1;
        }

        // delete value from bucket
        public void remove(int key) {
            var idx = -1;
            for (var i = 0; i < values.size(); i++) {
                if (values.get(i)[0] == key) {
                    idx = i;
                    break;
                }
            }
            if (idx >= 0) {
                values.remove(idx);
            }
        }
    }

    private Bucket[] buckets;

    public MyHashMap() {
        buckets = new Bucket[5557];
    }

    public void put(int key, int value) {
        var idx = Integer.hashCode(key) % buckets.length;
        if (buckets[idx] == null) {
            buckets[idx] = new Bucket();
        }

        buckets[idx].update(key, value);
    }

    public int get(int key) {
        var idx = Integer.hashCode(key) % buckets.length;
        if (buckets[idx] != null) {
            return buckets[idx].get(key);
        }
        return -1;
    }

    public void remove(int key) {
        var idx = Integer.hashCode(key) % buckets.length;
        if (buckets[idx] != null) {
            buckets[idx].remove(key);
        }
    }
}

package com.educative.grokking.exercises;

import com.educative.grokking.templates.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
Given a list of points on a plane, where the plane is a 2-D array with (x, y) coordinates, find the k
 closest points to the origin (0,0)
 */
public class KClosestPointstoOrigin {
    public static List<Point> kClosest(Point[] points, int k) {

        var heap = new PriorityQueue<Point>((o1, o2) -> Double.compare(o2.getDistance(), o1.getDistance()));
        for (int i = 0; i < Math.min(k, points.length); i++) {
            heap.offer(points[i]);
        }
        if (points.length > k) {
            for (int i = k; i < points.length; i++) {
                if (points[i].getDistance() < heap.peek().getDistance()) {
                    heap.poll();
                    heap.offer(points[i]);
                }
            }
        }

        return new ArrayList<>(heap);
    }
}

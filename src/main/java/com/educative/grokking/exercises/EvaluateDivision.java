package com.educative.grokking.exercises;

import java.util.HashMap;
import java.util.List;

public class EvaluateDivision {


    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {

        HashMap<String, String> parents = new HashMap<>();
        HashMap<String, Double> weights = new HashMap<>();

        // Step 1). build the union groups
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            double quotient = values[i];

            union(parents, weights, dividend, divisor, quotient);
        }

        // Step 2). run the evaluation, with "lazy" updates in find() function
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);

            if (!parents.containsKey(dividend) || !parents.containsKey(divisor))
                // case 1). at least one variable did not appear before
                results[i] = -1.0;
            else {
                Object[] dividendEntry = find(parents, weights, dividend);
                Object[] divisorEntry = find(parents, weights, divisor);

                String dividendGid = (String) dividendEntry[0];
                String divisorGid = (String) divisorEntry[0];
                Double dividendWeight = (Double) dividendEntry[1];
                Double divisorWeight = (Double) divisorEntry[1];

                if (!dividendGid.equals(divisorGid))
                    // case 2). the variables do not belong to the same chain/group
                    results[i] = -1.0;
                else
                    // case 3). there is a chain/path between the variables
                    results[i] = dividendWeight / divisorWeight;
            }
        }

        return results;
    }

    private Object[] find(HashMap<String, String> parents, HashMap<String, Double> weights, String nodeId) {
        parents.putIfAbsent(nodeId, nodeId);
        weights.putIfAbsent(nodeId, 1.0);

        var parent = parents.get(nodeId);
        var weight = weights.get(nodeId);
        if (!parent.equals(nodeId)) {
            var root = find(parents, weights, parent);
            parents.put(nodeId, (String) root[0]);
            weights.put(nodeId, (Double) root[1] * weight);
        }

        return new Object[]{parents.get(nodeId), weights.get(nodeId)};
    }

    private void union(HashMap<String, String> parents, HashMap<String, Double> weights, String dividend, String divisor, Double value) {
        var dividendEntry = find(parents, weights, dividend);
        var divisorEntry = find(parents, weights, divisor);

        String dividendGid = (String) dividendEntry[0];
        String divisorGid = (String) divisorEntry[0];
        Double dividendWeight = (Double) dividendEntry[1];
        Double divisorWeight = (Double) divisorEntry[1];

        if (!dividendGid.equals(divisorGid)) {
            parents.put(dividendGid, divisorGid);
            weights.put(dividendGid, divisorWeight * value / dividendWeight);
        }
    }
}

import java.util.Arrays;

class Solution {

    // Memoization table: memo[i][j] stores the minimum score to triangulate the sub-polygon
    // formed by vertices values[i], ..., values[j].
    // Using Integer to allow null checks for uncomputed states.
    private Integer[][] memo; 
    private int[] values; // Store the polygon vertex values

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        this.values = values;
        this.memo = new Integer[n][n];

        // The problem is to triangulate the polygon defined by vertices 0 to n-1.
        // We consider the edge (values[0], values[n-1]) as the base.
        return solve(0, n - 1);
    }

    private int solve(int i, int j) {
        // Base Case 1: If there are only 2 vertices (or fewer),
        // we cannot form a triangle, so the cost is 0.
        // A "polygon" requires at least 3 vertices.
        if (j - i < 2) { 
            return 0;
        }

        // Base Case 2: If the result for this sub-problem is already computed, return it.
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        long minScore = Long.MAX_VALUE; // Use long to prevent overflow during sum initially

        // Iterate through all possible 'k' such that 'values[k]' can be the third vertex
        // forming the first triangle (values[i], values[k], values[j])
        // that "splits" the polygon (i, ..., j).
        for (int k = i + 1; k < j; k++) {
            // Cost of the current triangle formed by (values[i], values[k], values[j])
            long currentTriangleCost = (long) values[i] * values[k] * values[j];

            // Recursively solve for the two sub-polygons created by this split:
            // 1. Sub-polygon (i, ..., k)
            // 2. Sub-polygon (k, ..., j)
            long totalCostForThisK = currentTriangleCost + solve(i, k) + solve(k, j);

            // Update minScore with the minimum cost found so far
            minScore = Math.min(minScore, totalCostForThisK);
        }

        // Store the computed minimum score in the memoization table before returning
        memo[i][j] = (int) minScore; // Cast back to int for storage
        return (int) minScore;
    }
}
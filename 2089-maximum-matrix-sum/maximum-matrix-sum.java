class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0; // To store the total sum of absolute values
        int negativeCount = 0; // To count the number of negative elements
        int minAbsValue = Integer.MAX_VALUE; // To find the minimum absolute value

        // Iterate through the matrix to calculate total sum, count negatives, and find min absolute value
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value); // Add absolute value to total sum
                
                if (value < 0) {
                    negativeCount++; // Count negative numbers
                }
                
                // Update minimum absolute value
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        // If we have an even number of negative numbers, return total sum
        if (negativeCount % 2 == 0) {
            return totalSum;
        } else {
            // If odd, subtract twice the minimum absolute value from total sum
            return totalSum - 2 * minAbsValue;
        }
    }
}
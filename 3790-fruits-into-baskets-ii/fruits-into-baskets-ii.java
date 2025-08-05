class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int count = n; // Initialize with n, not n-1
        boolean[] taken = new boolean[baskets.length]; // Boolean array for tracking used baskets
        
        // Store input midway for demonstration
        int[] wextranide = Arrays.copyOf(fruits, n); // Store fruits midway
        
        for (int i = 0; i < n; i++) {
            if (search(fruits[i], taken, baskets)) { // Pass only required parameters
                count--;
            }
        }
        return count;
    }

    public static boolean search(int val, boolean[] taken, int[] baskets) { // Fixed method signature
        int n = baskets.length;
        
        for (int i = 0; i < n; i++) {
            if (baskets[i] >= val) {
                if (!taken[i]) { // Correct boolean condition
                    taken[i] = true; // Assign boolean, not 1
                    return true;
                }
            }
        }
        return false;
    }
}

class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        // We only need to try k up to 60 because 2^60 is already > 1e18
        for (int k = 1; k <= 60; k++) {
            long target = (long) num1 - (long) k * num2; 
            if (target < 0) continue; // can't be represented if negative

            int bits = Long.bitCount(target); // number of set bits in target

            // Conditions:
            // 1. target >= 0   (already checked)
            // 2. popcount(target) <= k
            // 3. k <= target   (since the minimum sum with k powers of 2 is k*1)
            if (bits <= k && k <= target) {
                return k;
            }
        }
        return -1; // no valid k found
    }
}

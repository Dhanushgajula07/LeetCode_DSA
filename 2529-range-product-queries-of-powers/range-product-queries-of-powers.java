class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }
        int mod = 1_000_000_007;
        int m = powers.size();
        long[] prefix = new long[m + 1];
        prefix[0] = 1;
        for (int i = 0; i < m; i++) {
            prefix[i + 1] = (prefix[i] * powers.get(i)) % mod;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            long res = prefix[r + 1] * modInverse(prefix[l], mod) % mod;
            ans[i] = (int) res;
        }
        return ans;
    }
    // Modular inverse using Fermat's Little Theorem
    private long modInverse(long a, int mod) {
        long res = 1, pow = mod - 2;
        while (pow > 0) {
            if ((pow & 1) != 0) res = (res * a) % mod;
            a = (a * a) % mod;
            pow >>= 1;
        }
        return res;
    }
}
class Solution {
    public int numSub(String s) {
        long mod = 1_000_000_007;
        long ans = 0;
        long streak = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                streak++; // extend current run
            } else {
                ans = (ans + streak * (streak + 1) / 2) % mod;
                streak = 0; // reset
            }
        }

        // Add last streak if ended with '1'
        ans = (ans + streak * (streak + 1) / 2) % mod;

        return (int) ans;
    }
}

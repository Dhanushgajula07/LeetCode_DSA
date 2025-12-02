// class Solution {
//     public int countTrapezoids(int[][] points) {
//         // Map to count points at each y-level
//         Map<Integer, Integer> yCount = new HashMap<>();
//         for (int[] p : points) {
//             yCount.put(p[1], yCount.getOrDefault(p[1], 0) + 1);
//         }

//         // Collect all y-levels with at least 2 points
//         List<Integer> validY = new ArrayList<>();
//         for (int cnt : yCount.values()) {
//             if (cnt >= 2) validY.add(cnt);
//         }

//         long ans = 0, mod = 1_000_000_007L;
//         // For every pair of y-levels, multiply ways to pick 2 points from each
//         for (int i = 0; i < validY.size(); ++i) {
//             for (int j = i + 1; j < validY.size(); ++j) {
//                 long a = validY.get(i), b = validY.get(j);
//                 ans = (ans + (a * (a - 1) / 2) * (b * (b - 1) / 2)) % mod;
//             }
//         }
//         return (int) ans;
//     }
// }


class Solution {
    public int countTrapezoids(int[][] points) {
        final long MOD = 1000000007;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] p : points){
            freq.put(p[1], freq.getOrDefault(p[1], 0) + 1);
        }
        long total = 0, pairs = 0;
        for (int f : freq.values()){
            if (f <= 1){
                continue;
            }
            long pair = (long) f * (f - 1) / 2;
            total += pair;
            pairs += pair * pair;
        }
        return (int) ((total * total - pairs) / 2 % MOD);
    }
}
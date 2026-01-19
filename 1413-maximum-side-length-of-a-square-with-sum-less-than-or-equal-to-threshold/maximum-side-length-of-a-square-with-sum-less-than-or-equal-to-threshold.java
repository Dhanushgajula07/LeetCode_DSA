class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] pref = new int[m + 1][n + 1]; // 1-based indexing

        // Build prefix sum matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1]
                           + pref[i - 1][j]
                           + pref[i][j - 1]
                           - pref[i - 1][j - 1];
            }
        }

        int left = 0, right = Math.min(m, n), ans = 0;
        // Binary search on side length
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean found = false;
            for (int i = mid; i <= m; i++) {
                for (int j = mid; j <= n; j++) {
                    int sum = pref[i][j] - pref[i - mid][j] - pref[i][j - mid] + pref[i - mid][j - mid];
                    if (sum <= threshold) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
            if (found) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
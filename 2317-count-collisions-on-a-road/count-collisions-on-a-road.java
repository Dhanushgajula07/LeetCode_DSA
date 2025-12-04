class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n - 1;
        // Skip all leading 'L'
        while (left < n && directions.charAt(left) == 'L') left++;
        // Skip all trailing 'R'
        while (right >= 0 && directions.charAt(right) == 'R') right--;
        int collisions = 0;
        // All cars in between that are not 'S' will eventually collide
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') collisions++;
        }
        return collisions;
    }
}
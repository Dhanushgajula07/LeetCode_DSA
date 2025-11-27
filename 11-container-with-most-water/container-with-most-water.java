class Solution {
    public int maxArea(int[] height) {
        // brute force is O(n^2)
        // so i need O(n)
        int l = 0;
        int n = height.length;
        int r = n-1;

        int max = Integer.MIN_VALUE;
        while(l<r){
            int left = height[l];
            int right = height[r];
            int dist = r - l;
            if(left <= right){
                int ans = dist * left;
                max = Math.max(max,ans);
                l++;
            }
            else{
                int ans = dist * right;
                max = Math.max(max,ans);
                r--;
            }
        }

        return max;
    }
}
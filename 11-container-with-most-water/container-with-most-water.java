class Solution {
    public int maxArea(int[] height) {
        // use only 2 poiners
        // left and right
        int l = 0;
        int r = height.length - 1 ;

        int ans = 0;

        while(l<r){
            int dis = r - l ;

            if(height[l] < height[r]){
                ans = Math.max(ans,dis * height[l]);
                l++;
            }
            else{
                ans = Math.max(ans, dis * height[r]);
                r--;
            }
        }

        return ans;
    }
}
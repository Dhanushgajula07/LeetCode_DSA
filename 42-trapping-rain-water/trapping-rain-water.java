class Solution {
    public int trap(int[] height) {
        int n = height.length; 
        int l =0;
        int r = n-1;

        int lmax = 0;
        int rmax = 0;

        int ans = 0;

        while(l <= r){
            lmax = Math.max(lmax,height[l]);
            rmax = Math.max(rmax,height[r]);
            if(height[l] < height[r]){
                ans += Math.min(lmax,rmax) - height[l];
                l++;
            }
            else{
                ans += Math.min(lmax,rmax) - height[r];
                r--;
            }
        }

        return ans;
    }
}
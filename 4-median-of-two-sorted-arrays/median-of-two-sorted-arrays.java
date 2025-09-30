class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    return solve(m,n,nums1,nums2);
    }
    public double solve(int m,int n,int[]arr1,int [] arr2){
        if(n<m){
            // reverse arrays
            return solve(n,m,arr2,arr1);
        }
        int low = 0;
        int high = m;
        int left = (m + n +1) /2;
        while(low <= high){
            int mid1 = low + (high - low)/2;
            int mid2 = left - mid1;

            int l1 = (mid1 > 0) ? arr1[mid1 -1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? arr2[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < m ) ?  arr1[mid1]: Integer.MAX_VALUE;
            int r2 = (mid2<n) ? arr2[mid2]  :Integer.MAX_VALUE;

            if(l1 > r2){
                high =  mid1-1;
            }
            else if(l2 > r1){
                low = mid1 + 1;
            }
            else if (l1<= r2 && l2 <= r1){
                if((m + n) % 2 ==0){
                    return (double) (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                }
                else{
                    return (double) Math.max(l1,l2);
                }
            }
        }
        return 0;
    }
}
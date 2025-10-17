class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // learn how to send arraylist of int[] to int[][]
        // so 2 arrays and sorted that mean that number if passed not appearning again
        // perfect for 2 pointers

        int l = 0;
        int r = 0;
        int n = nums1.length;
        int m = nums2.length;

        ArrayList<int[]> ans = new ArrayList<>();
        while(l<n && r <m){
            int[] val1 = nums1[l];
            int[] val2 = nums2[r];
            if(val1[0] == val2[0]){
                ans.add(new int[]{val1[0],val1[1] + val2[1]});
                l++;
                r++;
            }
            else if(val1[0] < val2[0]){
                ans.add(new int[]{val1[0],val1[1]});
                l++;
            }
            else{
                ans.add(new int[]{val2[0],val2[1]});
                r++;
            }
        }

        while(l<n){
            int[] val1 = nums1[l];
            ans.add(new int[]{val1[0],val1[1]});
            l++;
        }
        while(r<m){
            int[] val2 = nums2[r];
            ans.add(new int[]{val2[0],val2[1]});
            r++;
        }

        int[][] result = ans.toArray(new int[ans.size()][]);

        return result;
    }
}
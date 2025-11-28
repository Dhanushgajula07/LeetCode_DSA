class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int r = arr.length - 1;

        while((r - l + 1) > k){
            // move
            int a = arr[l];
            int b = arr[r];
            if((Math.abs(a - x) < Math.abs(b - x)) || (Math.abs(a - x) == Math.abs(b - x))){
                r--;
            }
            else {
                l++;
            }
        }

        while(l<=r){
            ans.add(arr[l++]);
        }

        return ans;
    }
}
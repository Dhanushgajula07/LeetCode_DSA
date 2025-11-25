// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         return Atmost(nums,k) - Atmost(nums,k-1);
//     }

//     private int Atmost(int[] nums,int k){

//         if(k<0) return 0;
//         int cnt =0;
//         int n = nums.length;
//         int l=0;
//         int sum = 0;
//         for(int r =0;r<n;r++){
//             sum += nums[r];

//             while(sum > k){
//                 // shrink
//                 sum -= nums[l];
//                 l++;
//             }
//             cnt += (r - l + 1);
//         }
//         return cnt;
//     }
// }



class Solution {
    public int subarraySum(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,1);
    int n = nums.length;
    int count = 0;
    int sum = 0;
    for(int i=0;i<n;i++){
        sum += nums[i];
        if(map.containsKey(sum - k)){
            count += map.get(sum - k);
        }
        map.put(sum,map.getOrDefault(sum,0) + 1);
    }

    return count;
    }
}
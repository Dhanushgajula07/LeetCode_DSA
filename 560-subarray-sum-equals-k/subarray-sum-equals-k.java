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
//             // since its atmost that mean sum <= shoud be counted
//             cnt += (r - l + 1); // no of sub arrays between r and l 
//         }
//         return cnt;
//     }
// }



class Solution {
    public int subarraySum(int[] nums, int k) {
    // so its the pref sum pattern why?
    // becuase if i know if sum - k exist then i can know how many times sum == k exist
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,1); // sum 0 1 time at index 0 because its count
    int count = 0;
    int sum = 0;
    for(int num : nums){
        sum += num;
        if(map.containsKey(sum - k)){
            // then their exsist sum == k
            count += map.get(sum - k);
        }
        map.put(sum,map.getOrDefault(sum,0) + 1);
    }
    return count;
    }
}
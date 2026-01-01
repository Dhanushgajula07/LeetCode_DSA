class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // so its about devision, when is it divisble if reminder is 0
        // when is it not if its not 0
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); // -> this will guie wrong ans becuase its like having 0 mean divisble 
        int sum = 0;
        int count = 0;
        for(int num : nums){
            sum += num;
            int rem = sum % k;
            // need to handle negative remainders by converting them to positive using:

            if(rem < 0) rem = (rem + k) % k;
            if(map.containsKey(rem)){
                // that is sum % k == 0
                count += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0) + 1);
        }
        return count;
    }
}
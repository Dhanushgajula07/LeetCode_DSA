class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
    //if(sum % k == 0) return 0;
    int reminded = sum % k;
    return reminded == 0 ? 0:reminded ;
    }
}
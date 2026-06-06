class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // we can use th trick that is voting rules
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        // Edge case: If the array has only 1 or 2 elements, handle directly.
        if (n == 1) {
            ans.add(nums[0]);
            return ans;
        }
        if (n == 2) {
            if (nums[0] == nums[1]) {
                ans.add(nums[0]);
            } else {
                ans.add(nums[0]);
                ans.add(nums[1]);
            }
            return ans;
        }
        int num1 = 0;
        int num2 = 0;

        int cnt1 = 0;
        int cnt2 = 0;
        // their can be onlt 2 numbers that are more than n//3 times
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) { // it martches one number
                cnt1++;
            } else if (nums[i] == num2) { // it matches another number
                cnt2++;
            } else if (cnt1 == 0) { // it matches with none and also cnt is 0
                num1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) { // it matches with none and also cnt is 0
                num2 = nums[i];
                cnt2 = 1;
            } else { // no match and also its not 0
                cnt1--;
                cnt2--;
            }

        }

        // its not garent that its the answer so cross chekc again
        
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == num1) {
                cnt1++;
            } else if (num == num2) {
                cnt2++;
            }
        }

        if (cnt1 > n / 3) {
            ans.add(num1);
        }
        if (cnt2 > n / 3) {
            ans.add(num2);
        }

        return ans;
    }
}
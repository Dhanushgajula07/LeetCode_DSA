class Solution {
    public int findDuplicate(int[] nums) {
        // so lets solve it using HashMap.
        // and that has a TC-> O(n)
        // SC -> O(n)

        // or we can use HASHSET
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }

        return -1;
    }
}
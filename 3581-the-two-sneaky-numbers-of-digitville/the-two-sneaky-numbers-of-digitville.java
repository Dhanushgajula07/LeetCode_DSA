class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        // its  a single number 2 in desghise
        // better hashmap
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int[] ans = new int[2];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 2){
                ans[i] = entry.getKey();
                i++;
            }
        }

        return ans;
    }
}
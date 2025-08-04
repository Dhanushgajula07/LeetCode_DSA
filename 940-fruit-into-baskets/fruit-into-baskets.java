class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int len = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        // hashmap + sliding
        int left = 0;
        for(int right = 0;right<n;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size() > 2){
                map.put(fruits[left],map.get(fruits[left]) - 1);
                
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }         

                left++;   
            }
            len = Math.max((right - left + 1),len);
        }

        return len;
    }
}
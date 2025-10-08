class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // brute force is quite common of 2 for loops
        // which is o(n^2)

        // need to optimnise it
        // better ius that i will sort the potions because they just want the count
        Arrays.sort(potions);
        int n = spells.length;
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            int count = lowerBound(potions,success,spells[i]);
            ans[i] = potions.length - count;
        }


        return ans;
     }
     // the 1st elemt whuch is >=
     public int lowerBound(int[] potions,long req,int spell){
        int low = 0;
        int high = potions.length-1;
        int ans = potions.length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            long val = (long) spell * potions[mid];
            if(val >= req){
                ans = mid;
                // can be an answer but try lower
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
     }
}
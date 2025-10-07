// class Solution {
//     public int[] avoidFlood(int[] rains) {
//         // ok so lets solve itr using a stack because it makes sensce
//         // constarints also support my approach
//         Stack<Integer> st = new Stack<>();

//         // now lets create an answer array
//         int n = rains.length;

//         int[] ans = new int[n];
//         Arrays.fill(ans,-1);

//         // now lets loop and mark ans
//         for(int i = 0;i<n;i++){
//             if(rains[i] != 0){
//                 // its raining 
//                 // so mark -1 and add to stack
//                 ans[rains[i] - 1] = -1;
//                 st.push(rains[i]);
//             }
//             else if(rains[i] == 0){
//                 // no rains so pick stack and dry it
//                 int lake  = st.pop();
//                 ans[i] = lake;
//             }
//         }
//         return ans;      
//     }
// }



import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1); // default to 1 for unused dry days
        
        // Map lake -> last day it was filled
        Map<Integer, Integer> full = new HashMap<>();
        // Set of dry days
        TreeSet<Integer> dryDays = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            
            if (lake == 0) {
                // record dry day index
                dryDays.add(i);
            } else {
                // it rains
                ans[i] = -1;
                
                if (full.containsKey(lake)) {
                    // lake was already full -> must dry it before today
                    int lastFilled = full.get(lake);
                    Integer dryDay = dryDays.higher(lastFilled); // find next dry day
                    
                    if (dryDay == null) {
                        // no day to dry this lake -> impossible
                        return new int[0];
                    }
                    
                    ans[dryDay] = lake; // dry this lake on that day
                    dryDays.remove(dryDay);
                }
                
                full.put(lake, i); // mark this lake as filled today
            }
        }
        
        return ans;
    }
}


// | Method      | Meaning              |
// | ----------- | -------------------- |
// | .higher(x)  | smallest element > x |
// | .lower(x)   | largest element < x  |
// | .ceiling(x) | smallest element ≥ x |
// | .floor(x)   | largest element ≤ x  |

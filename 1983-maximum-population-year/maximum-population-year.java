class Solution {
    public int maximumPopulation(int[][] logs) {
        // since that supports Brute fortce i can easily tyry it

//         \U0001f9ea Brute Force Plan (Clear Steps)

// Iterate from 1950 to 2050.

// For each year y, loop through all logs and count how many people are alive (birth <= y < death).

// Track the maximum population and the earliest year with that max.

    int max = Integer.MIN_VALUE;
    int ans = 0;
    for(int i = 1950;i<2050;i++){
        int count = 0;
        for(int j = 0;j<logs.length;j++){
            int start  = logs[j][0];
            int end = logs[j][1] ;

            if(start <= i && i < end){
                count++;
            }
        }
        if(count > max){
            ans = i;
            max = count;
        }
    }
    return ans;
    }
}
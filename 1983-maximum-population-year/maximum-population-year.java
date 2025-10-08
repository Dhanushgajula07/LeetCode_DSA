class Solution {
    public int maximumPopulation(int[][] logs) {
// since that supports Brute fortce i can easily tyry it
// \U0001f9ea Brute Force Plan (Clear Steps)
// Iterate from 1950 to 2050.
// For each year y, loop through all logs and count how many people are alive (birth <= y < death).
// Track the maximum population and the earliest year with that max.

    // int max = Integer.MIN_VALUE;
    // int ans = 0;
    // for(int i = 1950;i<2050;i++){
    //     int count = 0;
    //     for(int j = 0;j<logs.length;j++){
    //         int start  = logs[j][0];
    //         int end = logs[j][1] ;

    //         if(start <= i && i < end){
    //             count++;
    //         }
    //     }
    //     if(count > max){
    //         ans = i;
    //         max = count;
    //     }
    // }
    // return ans;
    // }


    // now for further optimisation lest use LINESWEEP mthod

    int minYear = Integer.MAX_VALUE;
        int maxYear = Integer.MIN_VALUE;

        for (int[] log : logs) {
            minYear = Math.min(minYear, log[0]);
            maxYear = Math.max(maxYear, log[1]);
        }

        // 2️⃣ Create a difference array for the range
        int[] diff = new int[maxYear - minYear + 2]; // +2 for safety on last index

        // 3️⃣ Mark +1 at birth and -1 at death
        for (int[] log : logs) {
            diff[log[0] - minYear] += 1;
            diff[log[1] - minYear] -= 1;  // death year not counted
        }

        // 4️⃣ Sweep through the array (prefix sum) and track max population
        int maxPop = 0;
        int currPop = 0;
        int year = minYear;

        for (int i = 0; i < diff.length; i++) {
            currPop += diff[i];
            if (currPop > maxPop) {
                maxPop = currPop;
                year = minYear + i;
            }
        }

        return year;
    }
}
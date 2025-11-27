// class Solution {
//     public int numRescueBoats(int[] people, int limit) {
//         // i feel ist BSON
//         int min = 1;
//         int n = people.length;
//         int max = n-1;
//         int ans = -1;
//         while(min <= max){
//             int mid = min + (max - min) /2;
//             if(is_possible(mid,limit,people)){
//                 // try lower no of boats
//                 ans = mid;
//                 max = mid -1;
//             }
//             else{
//                 min = mid + 1;
//             }
//         }
//         return ans;
//     }
//     public boolean is_possible(int boats, int limit, int[] people) {
//     Arrays.sort(people);
//     int left = 0;
//     int right = people.length - 1;
//     int usedBoats = 0;

//     while (left <= right) {
//         // Try to fit the lightest and heaviest together
//         if (people[left] + people[right] <= limit) {
//             left++;
//         }
//         right--;
//         usedBoats++;
//         // If we've used more boats than allowed, return false
//         if (usedBoats > boats) return false;
//     }
//     return true;
// }
// }



// BSON is not working becaus eits not monotonic

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;  // if they fit together, send both
            }
            right--;    // else send heaviest alone
            boats++;
        }
        return boats;
    }
}

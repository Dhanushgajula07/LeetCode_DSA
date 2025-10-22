// class Solution {
//     public boolean canThreePartsEqualSum(int[] arr) {
//         // i caan try the lsum, rsum, midsum method
//         int total  = 0;
//         for(int num : arr){
//             total += num;
//         }

//         int lsum = 0;
//         int rsum = 0;
//         int l = 0;
//         int n = arr.length;
//         int r = n -1;
//         if(n < 3) return false;
//         while(l + 1 < r){
//             lsum += arr[l];
//             l++;
//             rsum += arr[r];
//             r--;
//             int mid = total - (lsum + rsum);

//             if(lsum == rsum && rsum == mid) return true;
//         }

//         return false;
//     }
// }

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
    // so previous approach fails because it does not garenty always that mid sum is non empty and its l++ and r --  are ubnormal


    // so we will use target sum trick
    int total = 0;
    for(int num : arr){
        total += num;
    }
    int target  = total / 3;
    if(total % 3 != 0) return false;
    int currentSum = 0;
    int count  = 0;

    for(int i = 0;i<arr.length ;i++){
        currentSum += arr[i];
        if(currentSum == target){
            count++;
            currentSum = 0;
        }
    }
    return count >= 3;
    }
}
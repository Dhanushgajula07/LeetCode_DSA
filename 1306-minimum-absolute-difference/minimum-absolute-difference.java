import java.util.*;

class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Prepare result list
        List<List<Integer>> result = new ArrayList<>();

        // Step 3: Find the minimum difference
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        // Step 4: Collect all pairs with minimum difference
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        // Step 5: Return the result
        return result;
    }
}
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int n = basket1.length;
        int globalMin = Integer.MAX_VALUE;

        // Step 1: Count imbalance
        for (int i = 0; i < n; i++) {
            count.put(basket1[i], count.getOrDefault(basket1[i], 0) + 1);
            count.put(basket2[i], count.getOrDefault(basket2[i], 0) - 1);
            globalMin = Math.min(globalMin, Math.min(basket1[i], basket2[i]));
        }

        List<Integer> excess = new ArrayList<>();

        // Step 2: Build list of excess items
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if (val % 2 != 0) return -1; // Odd imbalance not fixable

            // Take half of the imbalance (because each swap fixes two items)
            for (int i = 0; i < Math.abs(val) / 2; i++) {
                excess.add(key);
            }
        }

        // Step 3: Sort and calculate cost
        Collections.sort(excess);
        long cost = 0;

        // Only half of the list is needed as swaps are symmetric
        for (int i = 0; i < excess.size() / 2; i++) {
            cost += Math.min(excess.get(i), 2 * globalMin); // choose cheaper option
        }

        return cost;
    }
}
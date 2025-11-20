class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // Sort by end ascending, and if tie, by start descending
        Arrays.sort(intervals, (a, b) -> 
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        List<Integer> selected = new ArrayList<>();
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // Count how many selected numbers are inside current interval
            int count = 0;
            for (int i = selected.size() - 1; i >= 0; i--) {
                if (selected.get(i) >= start && selected.get(i) <= end) {
                    count++;
                    if (count == 2) break;
                }
            }

            // If less than 2, add missing numbers starting from end
            while (count < 2) {
                selected.add(end - (1 - count));  // add end, then end-1
                count++;
            }
        }

        return selected.size();
    }
}

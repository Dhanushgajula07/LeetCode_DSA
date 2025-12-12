import java.util.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        // Each event: [type, timestamp, data]
        // We need to sort by timestamp, OFFLINE before MESSAGE at same timestamp
        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2) return t1 - t2;
            // OFFLINE before MESSAGE
            if (!a.get(0).equals(b.get(0))) {
                return a.get(0).equals("OFFLINE") ? -1 : 1;
            }
            return 0;
        });

        Set<Integer> offline = new HashSet<>();
        // PriorityQueue to track when users come back online: [backOnlineTime, userId]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));

        for (List<String> event : events) {
            int currTime = Integer.parseInt(event.get(1));
            // Bring users back online if their offline period is over
            while (!pq.isEmpty() && pq.peek()[0] <= currTime) {
                offline.remove(pq.poll()[1]);
            }
            if (event.get(0).equals("OFFLINE")) {
                int id = Integer.parseInt(event.get(2));
                offline.add(id);
                pq.offer(new int[]{currTime + 60, id});
            } else { // MESSAGE
                String mentionsStr = event.get(2);
                if (mentionsStr.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) mentions[i]++;
                } else if (mentionsStr.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (!offline.contains(i)) mentions[i]++;
                    }
                } else {
                    String[] tokens = mentionsStr.split(" ");
                    for (String tok : tokens) {
                        if (tok.startsWith("id")) {
                            int id = Integer.parseInt(tok.substring(2));
                            mentions[id]++;
                        }
                    }
                }
            }
        }
        return mentions;
    }
}
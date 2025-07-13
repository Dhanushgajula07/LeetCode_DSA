class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int m = players.length;
        int n = trainers.length;

        Thread t1 = new Thread(() -> Arrays.sort(players));
        Thread t2 = new Thread(() -> Arrays.sort(trainers));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        int i = 0, j = 0, count = 0;
        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                i++;
                count++;
            }
            j++;
        }
        return count;
    }
}
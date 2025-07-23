class Solution 
{
    public int maximumGain(String s, int x, int y) 
    {
        // Step 1: Decide which pair has more value and remove it first
        if (x < y) 
        {
            return remove(s, 'b', 'a', y, x); // remove "ba" first
        } 
        else 
        {
            return remove(s, 'a', 'b', x, y); // remove "ab" first
        }
    }

    private int remove(String s, char first, char second, int firstPoints, int secondPoints) 
    {
        int score = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;

        // Step 2: First pass to remove the higher-value pair greedily
        char[] stack = new char[n];
        int idx = 0;
        for (char c : arr) 
        {
            if (idx > 0 && stack[idx - 1] == first && c == second) 
            {
                idx--;
                score += firstPoints; // Found a valuable pair, remove and add score
            } 
            else 
            {
                stack[idx++] = c; // Keep character for further processing
            }
        }

        // Step 3: Second pass to remove the lower-value pair from the remaining string
        int idx2 = 0;
        char[] stack2 = new char[n];
        for (int i = 0; i < idx; i++) 
        {
            char c = stack[i];
            if (idx2 > 0 && stack2[idx2 - 1] == second && c == first) 
            {
                idx2--;
                score += secondPoints;
            } 
            else 
            {
                stack2[idx2++] = c;
            }
        }

        // Step 4: Return total score
        return score;
    }
}
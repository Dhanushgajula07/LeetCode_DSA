class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        return search(0,letters.length - 1,target,letters);
    }
    public char search(int low, int high, char target,char[] letters){
        
        char ans = letters[0];
        while(low <= high){
            int mid = low + (high - low) / 2;
        if(letters[mid] <= target){
            low = mid +1;
        }
        else  {
            if(letters[mid] > target)
            ans = letters[mid];
            high = mid - 1;
        }
        }
        return ans;
    }
}
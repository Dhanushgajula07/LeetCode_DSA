// \U0001f50d Why is lastValue used?
                // It's specifically for handling the * operator, which has higher precedence than + and -.
                // But for *, we must "undo" the last addition/subtraction and apply multiplication first.
                // currentValue - lastValue + (lastValue * numValue)
                // This effectively reverses the last op (+3) and applies the multiplication properly.


public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        solve(num, target, 0, 0, 0, "", ans);
        return ans;
    }

    // Helper function to perform the DFS/backtracking
    private void solve(String num, int target, int start, long currentValue, long lastValue, String currentExpression, List<String> ans) {
        // If we've consumed the entire string
        if (start == num.length()) {
            if (currentValue == target) {
                ans.add(currentExpression); // If the value matches the target, add to the result
            }
            return;
        }

        // Try all possible lengths for the next number in the expression
        for (int i = start; i < num.length(); i++) {
            String currentNum = num.substring(start, i + 1);
            
            // Avoid numbers with leading zeros
            if (currentNum.length() > 1 && currentNum.charAt(0) == '0') {
                continue;
            }
            
            long numValue = Long.parseLong(currentNum);

            // For the first number, we don't add any operator
            if (start == 0) {
                solve(num, target, i + 1, numValue, numValue, currentNum, ans);
            } else {
                // Add the "+" operator
                solve(num, target, i + 1, currentValue + numValue, numValue, currentExpression + "+" + currentNum, ans);

                // Add the "-" operator
                solve(num, target, i + 1, currentValue - numValue, -numValue, currentExpression + "-" + currentNum, ans);

                // Add the "*" operator (this operator has higher precedence)
                solve(num, target, i + 1, currentValue - lastValue + (lastValue * numValue), lastValue * numValue, currentExpression + "*" + currentNum, ans);
            }
        }
    }
}

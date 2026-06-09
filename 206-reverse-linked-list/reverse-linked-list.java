/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// class Solution {
//     public ListNode reverseList(ListNode head) {
//         Stack<Integer> st = new Stack<>();
//          ListNode curr = head;
//          while(curr != null){
//             st.push(curr.val);
//             curr = curr.next;
//          }
//          curr = head;


//          while(curr != null){
//             curr.val = st.pop();
//             curr = curr.next;
//          }
//          return head;
//     }
// }


// // 1. iterative
// class Solution {
//     public ListNode reverseList(ListNode head) {
//     if(head == null || head.next == null){
//         // if null or only 1 that is the reverse
//         return head;
//     }

//     ListNode curr = head;
//     ListNode prev = null;
//     while(curr != null){
//         ListNode future = curr.next;
//         curr.next = prev;
//         prev = curr;
//         curr = future;
//     }
//     return prev;
//     }
// }


// 2. recursive
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // now if we want to solve it using recursion 
        // we will use IBH method
        return reverse(head);
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        // IBH
        // base done
        // hypo now
        ListNode reversed = reverse(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        
        return reversed;

    }
}
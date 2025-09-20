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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        ListNode mid = middle(curr);
        ListNode reversed = reverse(mid.next);  

        ListNode l1 = head;
        ListNode l2 = reversed;

        while(l2 != null){
            if(l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        mid.next = reverse(reversed);
        return true;
    }
    public ListNode middle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast  = fast.next.next;
            slow  = slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        // lets use past prtesent and future logic
        ListNode curr = head;
        ListNode past = null;

        while(curr != null){
            ListNode future = curr.next;
            curr.next = past;
            past = curr;
            curr = future;
        }
        return past;
    }
}
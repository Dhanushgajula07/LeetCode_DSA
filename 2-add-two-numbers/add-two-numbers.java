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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // i will create a dummy node and make use of a carry to make sure i add onlt units place and carry the extra tens place to later
    int carry = 0;
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;

    while(l1 != null || l2 != null || carry != 0){
        int sum = 0;
        if(l1 != null){
            sum += l1.val;
            l1 = l1.next;
        }
        if(l2 != null){
            sum += l2.val;
            l2 = l2.next;
        }
        sum += carry;
        ListNode temp = new ListNode(sum % 10);
        curr.next = temp;
        curr = temp;

        carry = sum / 10;
    }
    return dummy.next;
    }
}
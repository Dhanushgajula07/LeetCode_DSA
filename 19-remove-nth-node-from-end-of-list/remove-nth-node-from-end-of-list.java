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
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         // so basically move i can use 2 pointets
//         // 1. lets use that counting trick
//         int total = count(head);
//         int cut = total - n;
//         ListNode node = head;      
//         if(n== 1 && total == 1){
//             return null;
//         }


//         // this is more important Edge Case
//         if(n == total){
//             return head.next;
//         }
//         while(node != null){
//             cut--;
//             if(cut ==0 && node.next != null){
//                 node.next = node.next.next;
//                 break;
//             }
//             node = node.next;
//         } 
//         return head;
//     }
//     public int count(ListNode head){
//         int count = 0;
//         if(head == null){
//             return 0;
//         }
//         while(head != null){
//             count++;
//             head = head.next;
//         }
//         return count;
//     }
// }


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    // 2.approch we will use 2 pointers 
    ListNode fast = head;
    for(int i = 0;i<n;i++){
        fast = fast.next;
    }
    ListNode slow = head;
    if(fast == null) return head.next;
    while(fast.next != null){
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;

    return head;
    }
}
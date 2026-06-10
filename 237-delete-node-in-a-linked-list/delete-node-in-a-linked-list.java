/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // noot give
        if(node == null) return;
        
        // cody data of next to this
        node.val = node.next.val;

        // conect
        node.next = node.next.next;
    }
}
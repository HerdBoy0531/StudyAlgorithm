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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        int headSize = 1;

        while (cur.next != null) {
            cur = cur.next;
            headSize++;
        }
        
        cur.next = head;

        k = k % headSize;
        int cut = headSize - k;

        ListNode newTail = head;

        for (int i = 1; i < cut; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
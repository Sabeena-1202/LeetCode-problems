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
    public ListNode reversedList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while(current!=null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current= nextNode;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return ;
        }
        ListNode slow = head;
        ListNode fast  = head;
         while(fast.next!=null&&fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
         }
         ListNode secondHalf = reversedList(slow.next);
         slow.next = null;
         ListNode firstHalf = head;
         while(secondHalf!=null){
            ListNode firstNext = firstHalf.next;
            ListNode secondNext = secondHalf.next;
            
            firstHalf.next = secondHalf;
            secondHalf.next = firstNext;

            firstHalf = firstNext;
            secondHalf = secondNext;
         }
    }
}
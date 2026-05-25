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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode p = head;
        ListNode q = p.next;
        ListNode r=q;

        p.next =null;

        while(r!=null){
           
           r = r.next;
           q.next=p;
           p=q;
           q=r;
        }

        return p;


    }
}

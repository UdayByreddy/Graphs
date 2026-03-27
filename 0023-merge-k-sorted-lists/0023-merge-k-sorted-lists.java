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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)->a.val-b.val);
        for(ListNode list:lists){
            if(list!=null)
            pq.offer(list);
        }
        ListNode head = new ListNode();
        ListNode dummy = head;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            dummy.next =temp;
            dummy = dummy.next;
            if(temp.next!=null) pq.offer(temp.next);
        }
        return head.next;
        
    }
}
// TC : O(nklog(nk))
// SC : O(nk)
// BruteForce approach
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
        if(lists == null || lists.length == 0) return null;
        
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        
        for(ListNode list : lists){
            merged = merge(merged,list);
        }
        return merged.next;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while(p1!=null && p2!=null){
            
            if(p1.val<p2.val){
                curr.next = p1;
                p1 = p1.next;
            }
            else{
                curr.next = p2;
                p2 = p2.next;
            }
            curr= curr.next;
        }
        if(p1!=null){
            curr.next = p1;
        }
        if(p2!=null){
            curr.next = p2;
        }
        return dummy.next;
    }
}

// TC : O(nklog(k))
// SC : O(k)
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
        if(lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        for(ListNode head : lists){
            if(head!=null){
                pq.add(head);
            }
        }
        
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            if(min.next!=null){
                pq.add(min.next);
            }
            curr = curr.next;
        }
        
        return dummy.next;
    }
}


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        Stack<Integer> ll1 = new Stack<Integer>();
        Stack<Integer> ll2 = new Stack<Integer>();
        
        while(l1 != null) {
            ll1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            ll2.push(l2.val);
            l2 = l2.next;
        }
        ListNode last = null;
        ListNode current = null;
        while(!ll1.empty() || !ll2.empty()) {
            Integer nextL1 = ll1.empty() ? null : ll1.peek();
            Integer nextL2 = ll2.empty() ? null : ll2.peek();
            if (nextL1 == null ) {
                current = new ListNode(ll2.pop());
                current.next = last;
                last = current;
            } else if (nextL2 == null) {
                current = new ListNode(ll1.pop());
                current.next = last;
                last = current;
            } else if (nextL2 > nextL1) {
               current = new ListNode(ll2.pop());
                current.next = last;
                last = current;
                
            } else {
                current = new ListNode(ll1.pop());
                current.next = last;
                last = current;
                
            }
        }
        
        return current;
        
    }
}
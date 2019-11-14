public class RemoveNthNodeFromEndofList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if((level(head,n)+1)==n){
            return head.next;
        }
        return head;
    }

    public int level(ListNode node, int n) {
        if (node.next == null) {
            return 0;
        }
        int level = level(node.next, n) + 1;
        if (level == n) {
            node.next = node.next.next;
        }
        return level;
    }
}

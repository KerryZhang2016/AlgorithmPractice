package practice;

/**
 * 检测单链表是否有环
 * 并求环的起始位置
 *
 * Created by admin on 16/9/24.
 */
public class SearchCycleNode {

    private static ListNode equalListNode = null;//来记录判断有环时出现的相等的时的节点,姑且叫"相遇"节点。

    /**
     *  从"相遇"节点出发，第一个可达的节点（从单链表的头节点开始）即是单链表的环产生的起始位置
     * */
    public ListNode detectCycle(ListNode head) {
        if(!hasCycle(head)) return null;

        ListNode p = head;
        while(!isReach(p)){
            p = p.next;
        }
        return p;
    }

    /**
     *  判断从相遇的节点到head节点可达性
     * */
    private boolean isReach(ListNode head) {
        if(head == equalListNode) return true;
        ListNode p = equalListNode.next;
        while(p != equalListNode){
            if(p == head) return true;
            p = p.next;
        }
        return false;
    }


    /**
     * 判断是否有环
     *
     * 通过一个指针p走一步，一个指针q走两步，如果能出现p = q的情况，则有环，并记录p为相遇节点
     * */
    private boolean hasCycle(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return false;
        ListNode p = head;
        ListNode q = head.next;
        while(p != q) {
            if(p.next == null) return false;
            p = p.next;
            if(q.next == null) return false;
            if(q.next.next == null) return false;
            q = q.next.next;
        }
        equalListNode = p;
        return true;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}

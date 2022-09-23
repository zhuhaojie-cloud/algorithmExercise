package test.node;

public class LinkTest {

    //
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode lastNode = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }

            lastNode = lastNode.next;
        }
        lastNode.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }
    //递归实现
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
    //递归单链表逆序
    public static ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode result=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return result;
    }
    //非递归单链表逆序
    public static ListNode reverseList1(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode result=head;
        ListNode temp=head.next;
        result.next=null;
        while(temp!=null) {
            ListNode temp1 = temp;
            temp = temp.next;
            temp1.next = result;
            result = temp1;
        }
        return result;
    }
    //给定一个单链表的头节点 head,实现一个调整单链表的函数，
    // 使得每K个节点之间为一组进行逆序，并且从链表的尾部开始组起，头部剩余节点数量不够一组的不需要逆序。
    //链表:1->2->3->4->5->6->7->8->null, K = 3。
    // 那么 6->7->8，3->4->5，1->2各位一组。
    // 调整后：1->2->5->4->3->8->7->6->null。
    // 其中 1，2不调整，因为不够一组。
    //先递归逆序，然后递归k逆序
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        //判断节点的数量是否能够凑成一组
        if(temp == null)
            return head;
        ListNode t2 = temp.next;
        temp.next = null;  //如果把temp.next=null,那temp在head的位置也会=null，也就是说，这两个是用的同一个链表
        //把当前的组进行逆序
        ListNode newHead = reverseList(head);
        //把之后的节点进行分组逆序
        ListNode newTemp = reverseKGroup(t2, k);
        // 把两部分连接起来
        head.next = newTemp;
        return newHead;
    }
}

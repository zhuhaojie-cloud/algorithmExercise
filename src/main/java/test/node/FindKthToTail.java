package test.node;

public class FindKthToTail {
    //返回链表的倒数第k个节点
    public static Node findKthToTail(Node head, int k)
    {
        if(head == null || k == 0)
        {
            return null;
        }
        Node ahead = head;  //ahead是后指针
        Node behind = null;  //前指针
        //后指针指向顺数第k位置，前指针指向第一个位置，然后随后指针一起向后移动，
        // 当后指针移到末尾，前指针就只向了倒数第k个位置
        for (int i = 0; i < k - 1; i++) //后指针指向顺数第k个位置
        {
            if(ahead.Next != null)
            {
                ahead = ahead.Next;
            }
            else
            {
                return null;
            }
        }
        behind = head;
        while (ahead.Next != null)  //一起移动，当后指针到结尾时停止
        {
            ahead = ahead.Next;
            behind = behind.Next;
        }
        return behind;
    }
}

package test.node;

public class Node {
    public int Data;
    // 指向后一个节点
    public Node Next;
    // 指向前一个节点Prev
    public Node Prev;

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node next) {
        Next = next;
    }

    public Node getPrev() {
        return Prev;
    }

    public void setPrev(Node prev) {
        Prev = prev;
    }

    public Node(int data)
    {
        this.Data = data;
    }
}

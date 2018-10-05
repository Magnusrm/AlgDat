package Øving4;

public class DLL {
    Node head;
    Node tail;
    int length = 0;

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data, Node next, Node prev){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public void push(int newData){
        head = new Node(newData, head, null);
        if (tail == null) tail = head;
        else head.next.prev = head;
        length++;
    }

    public void add(int newData){
        Node newNode = new Node(newData, null, tail);
        if (tail != null) tail.next = newNode;
        else head = newNode;
        tail = newNode;
        length++;
    }
    public void insertAfter(Node prevNode, int newData){
        if (prevNode == null){
            System.out.println("The previous node cannot be null.");
            return;
        }
        Node newNode = new Node(newData, prevNode.next, prevNode);
        prevNode.next = newNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
        length++;
    }

    public String toString(){
        Node node = head;
        Node last = null;
        String res = "";
        while (node.data == 0) node = node.next;
        while (node != null){
            res += node.data;
            last = node;
            node = node.next;
        }
        return res;
    }
}

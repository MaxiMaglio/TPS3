package StacksAndQueues;

public class Node {
    Object data;
    Node next;

    public Node(Object x){
        data=x;
    }
    public Node(Object x, Node n){
        data=x;
        next = n;
    }
}

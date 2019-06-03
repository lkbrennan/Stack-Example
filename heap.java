package ie.dit;

import java.util.*;
class Queue{
    class Node{
        int data;
        Node next;
    }
    Node head,tail,z;

    Queue(){
        z= new Node();
        z.next=z;
        head=z;
        tail=null;
    }

    void enQueue(int x){
        Node t = new Node();
        t.data=x;
        t.next=z;
        if(head==z){
            head=t;
            tail=t;
        }
        else{
            tail.next=t;
        }
        tail=t;
    }

    int deQueue() throws StackException {
        if(this.isEmpty()) {
            throw new StackException("\nIllegal to pop() an empty Stack\n");
        }
        int x = head.data;
        head = head.next;
        return x;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size() {
        int c = 0;
        Node t = head;
        while(t != null) {
            ++c;
            t = t.next;
        }
        return c;
    }

    void display(){
        Node t = head;
        System.out.println("\nQueue contents are:  ");

        while (t != z) {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println("\n");
    }
}
}
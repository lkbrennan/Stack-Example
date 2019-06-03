/**
 * Created by Lauren on 27/04/2017.
 */
public class Main {
// StackTest.java
// Linked list implementation of Stack

    public static void main( String[] arg) throws StackException {
        Stack s = new Stack();
        System.out.println("Stack is created\n");

        // piece of code to test our exception mechanism
        try {
            s.pop();
        } catch (StackException e) {
            System.out.println("Exception thrown: " + e);
        }

        s.push('a'); s.push('d'); s.push('j'); s.push('a');
        s.display();
        s.count('a');
        s.remove('v');
        s.display();

        System.out.println("Stack size is " + s.size());

    /* int i = s.pop();
    System.out.println("Just popped " + i);
    s.display();
    */
    }
}

class StackException extends Exception {
    public StackException(String s) {
        super(s);
    }
}

class Stack {
    class Node {
        char data;
        Node next;
    }
    private Node top,tail,z;

    public Stack() {
        z=new Node();
        z.next=z;
        top=z;
        tail = null;
    }

    //pushes onto top of stack
    public void push(char x) {
        Node  t = new Node();
        t.data = x;
        t.next = z;
        if(top==z) {
            top = t;
            tail = t;
        }
        else {
            tail.next = t;
        }
        top = t;
    }

    //pops from top of stack
    public char pop() throws StackException
    {
        if(this.isEmpty()) {
            throw new StackException("\nIllegal to pop() an empty Stack\n");
        }
        char x = top.data;
        top = top.next;
        return x;
    }

    //checks if stack is empty
    public boolean isEmpty(){
       return top == null;
    }

    //checks size of stack
    public int size() {
        int c = 0;
        Node t = top;
        while(t != null) {
            ++c;
            t = t.next;
        }
        return c;
    }

    //displays stack contents
    public void display() {
        Node t = top;
        //Console.Write("\nStack contents are:  ");
        System.out.println("\nStack contents are:  ");

        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println("\n");
    }

    //counts how many times char x occurs in stack
    public int count(char x){
        int xcount=0;
        Node t = top;
        while(t!= null){
            if(t.data == x){
                xcount++;
                t=t.next;
            }
            else{
                t=t.next;
            }
        }
        System.out.println("\nThere are " + xcount + " occurences of " + x + "\n");
        return xcount;
    }

    //removes first occurence of char x in stack
    public boolean remove(char x) throws StackException{
        boolean exists = false;
        Node t = top;
        Node y;
        while(t!= null){
            if(t.data == x){
                exists=true;
                y=t.next;
                break;
            }
            else{
                exists=false;
                t=t.next;
            }
        }
        if (exists == true) {
            System.out.println("\n" + x + " has been removed  from Stack\n");
        }
        else{
            System.out.println("\n" + x + " does not exist in Stack\n");
        }
        return exists;
    }
}

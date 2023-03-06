import java.util.*;
public class StackB {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class Stack {
        //IMPLEMENTATION USING AL
        // static ArrayList<Integer> list = new ArrayList<>();

        // public static boolean isEmpty() {
        //     return list.size()==0;
        // }

        // public static void push(int data) {
        //     list.add(data);
        // }
        // public static int pop() {
        //     if(isEmpty()==true) {
        //         System.out.println("List is Empty");
        //         return -1;
        //     }
        //     int top = list.get(list.size()-1);
        //     list.remove(list.size()-1);
        //     return top;
        // }
        // public static int peek() {
        //     if(isEmpty()==true) {
        //         System.out.println("List is Empty");
        //         return -1;
        //     }
        //     return list.get(list.size()-1);
        // }
        //IMPLENTATION USING LL
        static Node head = null;
        public static boolean isEmpty() {
            return head == null;
        }
        public static void push(int data) {
            Node newNode = new Node(data);
            if(isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public static int pop() {
            if(isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        public static int peek() {
            if(isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        //Stack <Integer> s = new Stack<>(); //JCF
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()) { //until the stack is empty
            System.out.println(s.peek());
            s.pop();
        }
    }    
}

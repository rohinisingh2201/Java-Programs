import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueB {

    public static void interleave(Queue<Integer> q) {
        Queue <Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        for(int i=0; i<size/2; i++) {
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void reverse(Queue <Integer> q) {
        Stack <Integer> s = new Stack<>();
        while(!q.isEmpty()) {
            s.push(q.remove());
        }
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
        Queue <Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        //interleave(q);
        reverse(q);
        while(!q.isEmpty()) {
            System.out.print(q.remove()+ " ");
        }
        System.out.println();
    }
//     public static void printNonReapeat(String str) {
//         int freq[] = new int[26];
//         Queue <Character> q = new LinkedList<>();
//         for(int i=0; i<str.length(); i++) {
//             char ch = str.charAt(i);
//             q.add(ch);
//             freq[ch-'a']++;

//             while(!q.isEmpty() && freq[q.peek()-'a'] > 1) {
//                 q.remove();
//             }
//             if(q.isEmpty()) {
//                 System.out.print(-1 + " ");
//             } else {
//                 System.out.print(q.peek()+ " ");
//             }
//         }
//         System.out.println();
//     }
//     public static void main(String[] args) {
//         String str = "aabccxb";
//         printNonReapeat(str);
//     }
}
// public class QueueB {

//     static class Queue {
//         static int arr[];
//         static int size;
//         static int rear;
//         Queue(int n) {
//             arr = new int[n];
//             size = n;
//             rear = -1;
//         }
//         public static boolean isEmpty() {
//             return rear==-1;
//         }
//         //add
//         public static void add(int data) {
//             if(rear==size-1) {
//                 System.out.println("Queue is full");
//             }
//             rear = rear+1;
//             arr[rear] = data;
//         }
//         public static int remove() {
//             if(isEmpty()) {
//                 System.out.println("Queue is empty");
//                 return -1;
//             }
//             int front = arr[0];
//             for(int i=0; i<rear; i++) {
//                 arr[i] = arr[i+1];
//             }
//             rear = rear-1;
//             return front;
//         }
//         public static int peek() {
//             if(isEmpty()) {
//                 System.out.println("Queue is empty");
//                 return -1;
//             }
//             return arr[0];
//         }
//     }
//     public static void main(String[] args) {
//         Queue q = new Queue(5);
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         while(!q.isEmpty()) {
//             System.out.println(q.peek());
//             q.remove();
//         }
//     }
// }

//CIRCULAR QUEUE USING ARRAYS

// public class QueueB {

//     static class Queue {
//         static int arr[];
//         static int size;
//         static int rear;
//         static int front;
//         Queue(int n) {
//             arr = new int[n];
//             size = n;
//             rear = -1;
//             front = -1;
//         }
//         public static boolean isEmpty() {
//             return rear==-1 && front ==-1;
//         }
//         public static boolean isFull() {
//             return (rear+1)%size == front;
//         }
//         //add
//         public static void add(int data) {
//             if(isFull()) {
//                 System.out.println("Queue is full");
//                 return;
//             }
//             //add 1st element
//             if(front==-1) {
//                 front = 0;
//             }
//             rear = (rear+1)%size;
//             arr[rear] = data;
//         }
//         public static int remove() {
//             if(isEmpty()) {
//                 System.out.println("Queue is empty");
//                 return -1;
//             }
//             int result = arr[front];
//             //last el delete
//             if(rear == front) {
//                 rear = front = -1;
//             } else {
//                 front = (front+1) % size;
//             }
//             return result;
//         }
//         public static int peek() {
//             if(isEmpty()) {
//                 System.out.println("Queue is empty");
//                 return -1;
//             }
//             return arr[front];
//         }
//     }
//     public static void main(String[] args) {
//         Queue q = new Queue(5);
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         System.out.println(q.remove());
//         q.add(4);
//         System.out.println(q.remove());
//         q.add(5);

//         while(!q.isEmpty()) {
//             System.out.println(q.peek());
//             q.remove();
//         }
//     }
// }

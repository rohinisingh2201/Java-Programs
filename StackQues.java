import java.util.*;
public class StackQues {
    
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }

    public static String reverseStr(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }
    public static void reverseStack(Stack<Integer>s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void printStack(Stack<Integer>s) {
        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1; i<stocks.length; i++) {
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }

    public static boolean isValid(String str) {
        Stack <Character> s = new Stack<>();
        for(int i =0; i<str.length(); i++) {
            char ch = str.charAt(i);
            //opening
            if(ch=='(' || ch=='{' || ch=='[') {
                s.push(ch);
            } else {  //closing
                if(s.isEmpty()) {
                    return false;
                }
                if( (s.peek()=='(' && ch==')') 
                || (s.peek()=='{' && ch=='}')
                || (s.peek()=='[' && ch==']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicate(String str) {
        Stack <Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            //closing
            if(ch==')') {
                int count = 0;
                while(s.peek()!='(') {
                    s.pop();
                    count++;
                }
                if(count<1) {
                    return true; //duplicate
                } else {
                    s.pop();
                }
            } else {
                //opening
                s.push(ch);
            }
        }
        return false;
    }

    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nsr[]= new int[arr.length];
        int nsl[]= new int[arr.length];
        //next smaller right
        Stack <Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        //next smaller left
        s = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        //current area
        for(int i=0; i<arr.length; i++) {
            int ht = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = ht*width;
            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println("max area in the histogram: "+ maxArea);
    }
    public static void main(String[] args) {
        // Stack <Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s, 4);
        // while(!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }

        // String str = "abc";
        // String result = reverseStr(str);
        // System.out.println(result);

        //printStack(s);
        //3 2 1
        // reverseStack(s);
        // printStack(s);
        //1 2 3
       
        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);
        // for(int i=0; i<span.length; i++) {
        //     System.out.println(span[i] + " ");
        // }

        //next greater
        // int arr[] = {6, 8, 0, 1, 3};
        // Stack<Integer> s = new Stack<>();
        // int nextGreat[] = new int[arr.length];
        // for(int i = arr.length-1; i>=0; i--) {
        //     //1
        //     while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
        //         s.pop();
        //     }
        //     //2
        //     if(s.isEmpty()) {
        //         nextGreat[i] = -1;
        //     } else {
        //         nextGreat[i] = arr[s.peek()];
        //     }
        //     //3
        //     s.push(i);
        // }
        // for(int i=0; i<nextGreat.length; i++) {
        //     System.out.print(nextGreat[i] + " ");
        // }
        // System.out.println();

        String str = "({})[]";
        System.out.println(isValid(str));

        // String str = "((a+b))"; //true
        // String str2 = "(a-b)"; // false
        // System.out.println(isDuplicate(str2));

        // int arr[] = {2, 1, 5, 6, 2, 3};
        // maxArea(arr);
    }
}

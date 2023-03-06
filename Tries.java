public class Tries {
    
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq; //for prefix problem

        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
            freq = -1;
        }
    }
    public static Node root = new Node(); //empty root by default

    public static void insert(String word) {
        Node curr = root;
        for(int level = 0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';

            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } 
            //curr = curr.children[idx]; //update
            else {
                curr.children[idx].freq++; //for prefix
            }
        }
        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for(int i = 0; i<key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx]; //update
        }
        return curr.eow == true;
    }
    //word break problem
    public static boolean wordBreak(String key) {
        if(key.length() == 0) {
            return true;
        }
        for(int i=1; i<=key.length(); i++) {
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }
    //prefix prob
    public static void findPrefix(Node root, String ans) {
        if(root == null) {
            return;
        }
        if(root.freq == 1) {
            System.out.println(ans);
            return;
        }
        for(int i=0; i<root.children.length; i++) {
            if(root.children[i] != null) {
                findPrefix(root.children[i], ans+(char)(i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        // String words[] = {"the", "there", "their", "thee", "any"};
        // for(int i=0; i<words.length; i++) {
        //     insert(words[i]);
        // }
        //System.out.println(search("thee"));

        // String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        // for(int i=0; i<words.length; i++) {
        //     insert(words[i]);
        // }
        // String key = "ilikesamsung";
        // System.out.println(wordBreak(key));

        String arr[] = {"dog", "zebra", "dove", "duck"};
        for(int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }
        root.freq = -1;
        findPrefix(root, "");

    }
}

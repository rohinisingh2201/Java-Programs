import java.util.*;
public class BST {
    
    //insert in BST
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    //search in BST
    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
    //delete a node
    public static Node delete(Node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        } else if(root.data > val) {
            root.left = delete(root.left, val);
        } else {
            //case 1
            if(root.left == null && root.right == null) {
                return null;
            }
            //case 2
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }
            //case 3
            Node IS = findInSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node findInSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    //print in range
    public static void printRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2) {
            printRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printRange(root.right, k1, k2);
        }
        else if(root.data < k1) {
            printRange(root.left, k1, k2);
        } else {
            printRange(root.right, k1, k2);
        }
    }
    //root to leaf path
    public static void root2leaf(Node root, ArrayList<Integer>path) {
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) { //leaf node
            printPath(path);
        }
        root2leaf(root.left, path);
        root2leaf(root.right, path);
        path.remove(path.size()-1);
    }
    public static void printPath(ArrayList<Integer>path) {
        for(int i=0; i < path.size(); i++) {
            System.out.print(path.get(i) + "-->");
        }
        System.out.println("null");
    }
    //validate BST
    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }
        if(min != null && root.data <= min.data) {
            return false;
        }
        if(max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left, min, max) && isValidBST(root.right, min, max);
    }
    //mirror BST
    public static Node mirror(Node root) {
        if(root == null) {
            return null;
        }
        Node leftM = mirror(root.left);
        Node rightM = mirror(root.right);
        root.left = rightM;
        root.right = leftM;
        return root;
    }
    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    //array to BST
    public static Node createBST(int arr[], int st, int end) {
        if(st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }
    //BST to balanced BST
    public static Node balanceBST(Node root) {
        //inorder sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        //sorted to balan bst
        root = creaBST(inorder, 0, inorder.size()-1);
        return root;
    }
    public static void getInorder(Node root, ArrayList<Integer>inorder) {
        if(root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }
    public static Node creaBST(ArrayList<Integer> inorder, int st, int end) {
        if(st > end) {
            return null;
        }
        int mid = (st+end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = creaBST(inorder, st, mid-1);
        root.right = creaBST(inorder, mid+1, end);
        return root;
    }
    //largest bst in bt
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

        public static int maxBST = 0;

        public static Info largestBST(Node root) {
            if(root == null) {
                return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }
            Info leftInfo = largestBST(root.left);
            Info rightInfo = largestBST(root.right);
            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
            int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
            if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
                return new Info(false, size, min, max);
            }
            if(leftInfo.isBST && rightInfo.isBST) {
                maxBST = Math.max(maxBST, size);
                return new Info(true, size, min, max);
            }
            return new Info(false, size, min, max);
        }
        //merge BSTs
        public static Node mergeBST(Node root1, Node root2) {
            //1
            ArrayList<Integer>arr1 = new ArrayList<>();
            getInorder(root1, arr1);
            //2
            ArrayList<Integer>arr2 = new ArrayList<>();
            getInorder(root2, arr2);
            //3 merge
            int i=0, j=0;
            ArrayList<Integer>finalArr = new ArrayList<>();
            while(i<arr1.size() && j<arr2.size()) {
                if(arr1.get(i) < arr2.get(j)) {
                    finalArr.add(arr1.get(i));
                    i++;
                } else {
                    finalArr.add(arr2.get(j));
                    j++;
                }
            }
            while(i<arr1.size()) {
                finalArr.add(arr1.get(i));
                i++;
            }
            while(j<arr2.size()) {
                finalArr.add(arr2.get(j));
                j++;
            }
            //sorted to balanced bst
            return creaBST(finalArr, 0, finalArr.size()-1);
        }

    public static void main(String[] args) {
        // int values[] = {5, 1, 3, 4, 2, 7};
        // int values[] = {8, 5, 3, 6, 10, 11, 14};
        // Node root = null;
        // for(int i=0; i<values.length; i++) {
        //     root = insert(root, values[i]);
        // }
        // inorder(root);
        // System.out.println();
        // if(search(root, 2)) {
        //     System.out.println("found");
        // } else {
        //     System.out.println("not found");
        // }
        // root = delete(root, 7);
        // System.out.println();
        // inorder(root);
        // printRange(root, 5, 12);
        //root2leaf(root, new ArrayList<>());
        // if(isValidBST(root, null, null)) {
        //     System.out.println("Valid");
        // } else {
        //     System.out.println("Not Valid");
        // }
        // Node root = new Node(8);
        // root.left = new Node(5);
        // root.right = new Node(10);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);
        // root.right.right = new Node(11);
        // root = mirror(root);
        // preorder(root);
        // int arr[] = {3, 5, 6, 8, 10, 11, 12};
        // Node root = createBST(arr, 0, arr.length-1);
        // preorder(root);
        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);

        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);
        // root = balanceBST(root);
        // preorder(root);
        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);

        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // Info info = largestBST(root);
        // System.out.println("Largest bst size : " + maxBST);
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBST(root1, root2);
        preorder(root);
    }
}

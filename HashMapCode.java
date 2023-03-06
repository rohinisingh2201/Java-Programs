import java.util.*;

public class HashMapCode {
    static class HashMapC <K, V> {  //generic
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        private int n; //kitne nodes are added
        private int N;
        private LinkedList buckets[]; //array of linked list

        @SuppressWarnings("unchecked")
        
        public HashMapC() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++) {
                this.buckets[i] = new LinkedList(); //empty ll created
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode(); //form change & returns a code
            return Math.abs(hc) % N;
        }

        private int SearchInLL(K key, int bi) { 
            LinkedList ll = buckets[bi];
            int di=0;
            for(int i =0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")

        private void rehash() {
            LinkedList oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;
            for(int i=0; i<buckets.length; i++) {
                buckets[i] = new LinkedList(); //empty ll created
            }
            //nodes - add in new bucket
            for(int i=0; i<oldBuck.length; i++) {
                LinkedList ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) { //- 0(1)
            int bi = hashFunction(key); // 0 to size-1 only
            int di = SearchInLL(key, bi); //valid or not found

            if(di != -1) {
                Node node = buckets[bi].get(di);//finding the node
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n/N;
            if(lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) { // 0(1)
            int bi = hashFunction(key); // 0 to size-1 only
            int di = SearchInLL(key, bi); //valid or not found

            if(di != -1) {
                return true; //key exist (valid)
            } else { 
                return false;
            }
        }

        public V get(K key) { //0(1)
            int bi = hashFunction(key); // 0 to size-1 only
            int di = SearchInLL(key, bi); //valid or not found

            if(di != -1) {
                Node node = buckets[bi].get(di);//finding the node
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) { //0(1)
            int bi = hashFunction(key); // 0 to size-1 only
            int di = SearchInLL(key, bi); //valid or not found

            if(di != -1) {
                Node node = buckets[bi].remove(di);//removing
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList <K> keySet() { //returning all the keys
            ArrayList <K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++) {
                LinkedList ll = buckets[i];
                for(Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMapC <String, Integer> hm = new HashMapC();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 150);
        hm.put("Nepal", 5);

        ArrayList <String> keys = hm.keySet(); //all keys are returned
        for(String key : keys) {
            System.out.println(key);
        }
    }

}

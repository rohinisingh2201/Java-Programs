import java.util.*;
public class HashQues {
    
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap <Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch =  s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int i=0; i<t.length(); i++) {
            char ch = s.charAt(i);
            if(map.get(ch) != null) {
                if(map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch)-1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static String getStart(HashMap <String, String> tickets) {
        HashMap <String, String> revMap = new HashMap<>();
        for(String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key); //interchange
        }
        for(String key : tickets.keySet()) {
            if(!revMap.containsKey(key)) {
                return key; //starting point
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // String s = "race";
        // String t = "care";
        // System.out.println(isAnagram(s, t));

        //majority element
        // int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        // HashMap <Integer, Integer> map = new HashMap<>();
        // for(int i=0; i< arr.length; i++) {
        //     map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        // }
        // //Set <Integer> keySet = map.keySet();
        // for(Integer key : map.keySet()) {
        //     if(map.get(key) > arr.length/3) {
        //         System.out.println(key);
        //     }
        // }

        //count distinct elements
        // int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        // HashSet <Integer> set = new HashSet<>();
        // for(int i=0; i<num.length; i++) {
        //     set.add(num[i]);
        // }
        // System.out.println("Ans = " + set.size());

        //union & intersection
        // int arr1[] = {7, 3, 9};
        // int arr2[] = {6, 3, 9, 2, 9, 4};
        // HashSet <Integer> set = new HashSet<>();
        // //union
        // for(int i=0; i<arr1.length; i++) {
        //     set.add(arr1[i]);
        // }
        // for(int i=0; i<arr2.length; i++) {
        //     set.add(arr2[i]);
        // }
        // Iterator<Integer> it = set.iterator();
        // while(it.hasNext()) {
        //     System.out.print(it.next() + " ");
        // }
        // System.out.println();
        // System.out.println("Union: " + set.size());    
        // //intersect
        // set.clear();
        // for(int i=0; i<arr1.length; i++) {
        //     set.add(arr1[i]);
        // }
        // int count = 0;
        // for(int i=0; i<arr2.length; i++) {
        //     if(set.contains(arr2[i])) {
        //         count++;
        //         set.remove(arr2[i]);
        //         System.out.print(arr2[i] + " ");
        //     }
        // }
        // System.out.println("Intersection : " + count);

        //Subarray sum = K
        // int arr[] = {10, 2, -2, -20, 10};
        // int K = -10;
        // HashMap <Integer, Integer> map = new HashMap<>();
        // //sum,count
        // map.put(0, 1);
        // int sum = 0;
        // int ans = 0;
        // for(int j=0; j<arr.length; j++) {
        //     sum += arr[j]; //sum of j
        //     if(map.containsKey(sum-K)) {
        //         ans += map.get(sum-K);
        //     }
        //     map.put(sum, map.getOrDefault(sum, 0) + 1);
        // }
        // System.out.println(ans);

        //Largest SubArray with 0 sum
        // int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        // HashMap <Integer, Integer> map = new HashMap<>();
        // int sum = 0;
        // int len = 0;
        // for(int j=0; j<arr.length; j++) {
        //     sum += arr[j];
        //     if(map.containsKey(sum)) {
        //         len = Math.max(len, j - map.get(sum));
        //     } else {
        //         map.put(sum, j);
        //     }
        // }
        // System.out.println("Largest subarray : " + len);

        //Itineraray from tickets
        HashMap <String, String> tickets = new HashMap<>();
        tickets.put("Chennai" , "Bengaluru");
        tickets.put("Mumbai" , "Delhi");
        tickets.put("Goa" , "Chennai");
        tickets.put("Delhi" , "Goa");
        
        String start = getStart(tickets);
        System.out.print(start);
        for(String key : tickets.keySet()) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }
}

import java.util.*;
//import java.lang.*;
public class strings {
    
    public static boolean isPalin(String str) {
        for(int i=0; i<str.length()/2; i++) {
            int n= str.length();
            if(str.charAt(i)!= str.charAt(n-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static float shortpath(String path) {
        int x=0, y=0;
        for(int i=0; i<path.length(); i++) {
            char dir= path.charAt(i);
            if(dir=='S') {
                y--;
            } else if(dir=='N') {
                y++;
            } else if(dir=='W') {
                x--;
            } else {
                x++;
            }
        }
        int X2= x*x;
        int Y2= y*y;
        return (float)Math.sqrt(X2+Y2);
    }

    public static String largest(String str[]) {
        String lar= str[0];
        for(int i=0; i<str.length; i++) {
            if(lar.compareTo(str[i])<0) { //str>lar
                lar= str[i];
            }
        }
        return lar;
    }

    public static String toUpper(String str) {
        StringBuilder sb= new StringBuilder("");
        char ch= Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i)== ' ' && i<str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str) {
        String newStr=" ";
        for(int i=0; i<str.length(); i++) {
            Integer count =1;
            while(i<str.length()-1 && str.charAt(i)== str.charAt(i+1)) {
                count++;
                i++;
            }
            newStr+=str.charAt(i);
            if(count>1) {
                newStr+=count.toString();
            }
        }
        return newStr;
    }

    public static int lowercaseVowels(String s) {
        int c=0;
        for(int i=0; i<s.length(); i++) {
            int ch= s.charAt(i);
            if(ch>=97 && ch<=122) {
                if(ch=='a' || ch=='e' ||ch=='i' || ch=='o' || ch=='u') {
                    c++;
                }
            }
        }
        return c;
    }

    public static void anagram(String s1, String s2) {
        s1= s1.toLowerCase();
        s2= s2.toLowerCase();

        if(s1.length()==s2.length()) {
            //convert strings to char arrays
            char[] s1charArray= s1.toCharArray();
            char[] s2charArray= s2.toCharArray();
            //sorting the char array
            Arrays.sort(s1charArray);
            Arrays.sort(s2charArray);

            boolean result= Arrays.equals(s1charArray, s2charArray);
            if(result) {
                System.out.println(s1 +" and "+ s2 + " are anagrams of each other");
            } else {
                System.out.println(s1 + " and "+ s2+ " are not anagrams of each other");
            }
        } else {
            System.out.println(s1 + " and "+ s2+ " are not anagrams of each other");
        }
    }

    
    public static void main(String[] args) {
        //String str= "racecar";
        //System.out.println(isPalin(str));
        //String path= "WNEENESENNN";
        //System.out.println(shortpath(path));
        //String str[]= {"apple","mango","banana"};
        //System.out.println(largest(str));
        //String str= "my name is rohini";
        //System.out.println(toUpper(str));
        //String str= "aaabbcccdddd";
        //System.out.println((compress(str)));
        //String s= "Onion";
        //System.out.println(lowercaseVowels(s));
        String s1= "earth";
        String s2= "heart";
        anagram(s1, s2);
    }
}

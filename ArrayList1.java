import java.lang.reflect.Array;
import java.util.ArrayList;
public class ArrayList1 {
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        //brute force
        // for(int i=0; i<list.size(); i++) {
        //     for(int j=i+1; j<list.size(); j++) {
        //         if(list.get(i)+list.get(j)==target) {
        //             return true;
        //         }
        //     }
        // }
        // return false;
        //2 pointer approach - 0(n)
        int lp=0;
        int rp=list.size()-1;
        while(lp!=rp) {
            //case 1
            if(list.get(lp)+list.get(rp)==target) {
                return true;
            }
            //case 2
            if(list.get(lp)+list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }  
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int bp= -1;
        int n= list.size();
        for(int i=0; i<list.size(); i++) {
            if(list.get(i)>list.get(i+1)) { //breaking point
                bp=i;
                break;
            }
        }
        int lp= bp+1; //smallest num
        int rp= bp; //largest
        while(lp!=rp) {
            //case 1
            if(list.get(lp)+list.get(rp)== target) {
                return true;
            }
            //case 2
            if(list.get(lp)+list.get(rp)< target) {
                lp= (lp+1)%n;
            } else {
                rp= (n+rp-1)%n;
            }
        }
        return false;
    }
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater=0;
        // //brute force
        // for(int i=0; i<height.size(); i++) {
        //     for(int j= i+1; j<height.size(); j++) {
        //         int ht= Math.min (height.get(i), height.get(j));
        //         int width= j-i;
        //         int currWater= ht*width;
        //         maxWater= Math.max(maxWater, currWater);
        //     }
        // }
        // return maxWater;
        //2 pointer approach - O(n)
        int lp=0;
        int rp= height.size()-1;
        while(lp<rp) {
            int ht= Math.min(height.get(lp), height.get(rp));
            int width= rp-lp;
            int currWater= ht*width;
            maxWater= Math.max(maxWater, currWater);
            //update pointers
            if(height.get(lp)<height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void swap(ArrayList<Integer>num, int idx1, int idx2) {
        int temp= num.get(idx1);
        num.set(idx1, num.get(idx2));
        num.set(idx2, temp);
    }
    public static void print(ArrayList<Integer>num) {
        for(int i=0; i< num.size(); i++) {
            System.out.print(num.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // ArrayList<Integer> list= new ArrayList<>();
        // list.add(11);
        // list.add(15);
        // list.add(6);
        // list.add(8);
        // list.add(9);
        // list.add(10);
        // int target= 16;
        // //System.out.println(pairSum1(list, target));   
        // System.out.println(pairSum2(list, target));           
        ArrayList<Integer> height= new ArrayList<>();  
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        //System.out.println(storeWater(height));

        //multi-dimensional AL
        // ArrayList<ArrayList<Integer>>mainlist= new ArrayList<>();
        // ArrayList<Integer> list1= new ArrayList<>();
        // ArrayList<Integer> list2= new ArrayList<>();
        // ArrayList<Integer> list3= new ArrayList<>();
        // for(int i=1; i<=5; i++) {
        //     list1.add(i*1);
        //     list2.add(i*2);
        //     list3.add(i*3);
        // }
        // mainlist.add(list1);
        // mainlist.add(list2);
        // mainlist.add(list3);

        // for(int i=0; i<mainlist.size(); i++) {
        //     ArrayList<Integer>currList= mainlist.get(i); //mainlist's ith index has a list
        //     for(int j=0; j< currList.size(); j++) {
        // //         System.out.print(currList.get(j)+ " ");
        // //     }
        // //     System.out.println();
        // // }
        // // System.out.println(mainlist);

        //maximum in an AL
        ArrayList<Integer>num= new ArrayList<>();
        num.add(2);
        num.add(5);
        num.add(9);
        num.add(6);
        num.add(8);
        // int max= Integer.MIN_VALUE;
        // for(int i=0; i<num.size(); i++) {
        //     // if(max< num.get(i)) {
        //     //     max= num.get(i);
        //     // }
        //     max= Math.max(max, num.get(i));
        // }
        // System.out.println("maximum no: "+ max);
        int idx1= 1, idx2= 3;
        print(num);
        swap(num, idx1, idx2);
        print(num);
    }
} 

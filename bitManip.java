public class bitManip {
    
    public static void oddEven(int n) {
        int bitMask= 1;
        if((n & bitMask)==0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitMask= 1<<i;
        if((n & bitMask)==0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitMask= 1<<i;
        return n|bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask= ~(1<<i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // if(newBit==0) {
        //     return clearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }
        n = clearIthBit(n, i);
        int bitMask= newBit<<i;
        return n|bitMask;
    }
    public static void main(String[] args) {
        //oddEven(5);
        //System.out.println(getIthBit(10, 3));
        //System.out.println(setIthBit(3, 2));
        //System.out.println(clearIthBit(10, 1));
        System.out.println(updateIthBit(10, 2, 1));
    }
}

import java.util.*;

class abc {

    public static void decTobin(int n) {
        int myNum= n;
        int pow=0;
        int binNum=0;
        while(n>0) {
            int rem= n%2;
            binNum = binNum + (rem* (int)Math.pow(10, pow));
            pow++;
            n=n/2;
        }
        System.out.println("Binary of "+ myNum + " = "+ binNum);
    }
    public static void main(String[] args) {
        decTobin(6);
    }
}
// }
// import java.util.*;

// public class abc{
//     public static void main(String [] args){
//         Scanner sc=new Scanner (System.in);
//         System.out.println("Enter Rows: ");
//         int rows =sc.nextInt();
//         System.out.println("Enter coloumns: ");
//         int colmn= sc.nextInt();

//         int numbers [][]=new int [rows][colmn];
//         System.out.println("Enter the elements: ");
//         for (int i=0;i<rows ;i++){
//             for (int j=0;j<colmn;j++){
//                 numbers [i][j]=sc.nextInt();
//             }
//         }
//         System.out.println("Enter element to search: ");
//         int x=sc.nextInt();
//         for (int i=0;i<rows ;i++){
//             for (int j=0;j<colmn;j++){
//                 if (numbers [i][j] == x){
//                     System.out.println("numbers found at location " + i + j );
//                 }
//             }
//         }
//     }
// }
//import java.util.Arrays;
public class sorting {

    public static void bubble(int arr[]) {
        int swap=0;
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]) {
                    int temp= arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                    swap++;
                }
            }
        }
        if(swap<1) {
            System.out.println("ALREADY SORTED ARRAY");
        }
    }
    public static void selection(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            int minPos= i; //current
            for(int j= i+1; j<arr.length; j++) {
                if(arr[j]<arr[minPos]) {
                    minPos=j;
                }
            }
            int temp= arr[minPos];
            arr[minPos]= arr[i];
            arr[i]= temp;
        }
    }
    public static void insertion(int arr[]) {
        for(int i=1; i<arr.length; i++) {
            int curr= arr[i];
            int prev= i-1;
            while(prev>=0 && arr[prev]>curr) {
                arr[prev+1]= arr[prev];
                prev--; //comparing each by going backwards
            }
            arr[prev+1]= curr;
        }
    }

    public static void countSort(int arr[]) {
        int larg= Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            larg= Math.max(larg, arr[i]);
        }
        int count[]= new int[larg+1]; //+1 bc we're starting to count from zero
        for(int i=0; i<arr.length; i++) { //freq
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0; i<count.length; i++) {
            while(count[i]>0) {
                arr[j]= i;
                j++;
                count[i]--;
            }
        }
    }
    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        //int arr[] = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
        //int arr[] = {5,4,1,2,3};
        int arr[]= {1,2,3,5,4};
        bubble(arr);
        //selection(arr);
        //insertion(arr);
        //countSort(arr);
        //Arrays.sort(arr);
        printArr(arr);

    }
}

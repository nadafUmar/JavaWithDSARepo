import java.util.Scanner;

public class InsertionSort {

    static void insertionSort(int [] arr){
        int n=arr.length;

        for(int i=1;i< arr.length;i++){
            int unsortIndex=i;
            for(int  j=i-1;j>=0;j--){
                if(arr[unsortIndex]<arr[j]){
                    int temp=arr[unsortIndex];
                    arr[unsortIndex]=arr[j];
                    arr[j]=temp;
                    unsortIndex--;
                }else {
                    break;
                }
            }
        }
    }
    static void insertionByMam(int[] arr){
        int n= arr.length;

        for(int i=1;i<n;i++){
            int j=i;
            while (j>0 && arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int[] arr={90,50,80,12,30,15};
       // insertionSort(arr);
        insertionByMam(arr);
        System.out.println("sorted array using insertion sorting algorithm:");
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}

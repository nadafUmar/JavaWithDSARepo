import java.util.Scanner;

public class SelectionSort {

    static void selectionSortAlgo(int[] arr,int[] ans){//out_place algorithm(extra array used)

        for(int i=0;i<ans.length;i++) {
            int min_value=Integer.MAX_VALUE;
            int min_index=0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < min_value) {
                    min_value = arr[j];
                    min_index = j;
                }
            }
            ans[i]=min_value;
            arr[min_index]=Integer.MAX_VALUE;
        }
    }
    static void selectionSortInPlace(int [] arr){

        for(int i=0;i< arr.length-1;i++){
            int min_index=i;

            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[min_index]){
                    min_index=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[min_index];
            arr[min_index]=temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size of the array");
        int size= sc.nextInt();
        int [] arr=new int[size];
        int[] ans=new int[size];
        System.out.println("Enter "+size+" array elements");
        for(int i=0;i< arr.length;i++){
            arr[i]=sc.nextInt();
        }

//        selectionSortAlgo(arr,ans);
//        System.out.println("sorted array using extra array:");
//        for(int i:ans){
//            System.out.print(i+" ");
//        }

        selectionSortInPlace(arr);
        System.out.println("sorted array in same array:");
        for(int i:arr){
            System.out.print(i+" ");
        }

    }
}

public class QuickSort {
        static void quickSort(int[] arr,int l,int r) {
            if(l>=r) return;
            int pivot=arr[r];
            int count=0;
            int i=l;
            while(i<r){
                if(arr[i]<=pivot){
                    count++;
                }
                i++;
            }
            int pivot_index=l+count;
            int temp=arr[pivot_index];
            arr[pivot_index]=arr[r];
            arr[r]=temp;

            i=l;
            int j=pivot_index+1;
            while(i<pivot_index){
                if(arr[i]>arr[pivot_index]){
                    while(j<=r){
                        if(arr[j]<=arr[pivot_index]) {
                            int temp1 = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp1;
                            j++;
                            break;
                        }
                        j++;
                    }
                }
                i++;
            }

            quickSort(arr,l,pivot_index-1);
            quickSort(arr,pivot_index+1,r);
        }
    static void printArray(int[] arr){
        for (int val:arr) {
            System.out.print(val+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int[] arr={7,18,5,9,2,4,10};
        int n=arr.length;
        System.out.println("Array before sorting:");
        printArray(arr);

        quickSort(arr,0,n-1);
        System.out.println("Array after sorting");
        printArray(arr);
    }
}

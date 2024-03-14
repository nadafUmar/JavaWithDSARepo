public class CountSort {
    public static void basicCountSorting(int[] arr){ // not stable algorithm
        int i=0;
        int max=Integer.MIN_VALUE;
        while (i<arr.length){  //finding max value present in array arr
            if(arr[i]>max){
                max=arr[i];
            }
            i++;
        }
        int[] freqArray=new int[max+1];  //declaring frequency array with size max+1;

        i=0;
        int j=0;
        while(i<freqArray.length){ //this is a logic for frequency array
            int count=0;
            j=0;
           while (j<arr.length){
               if(arr[j]==i){
                   count++;
               }
               j++;
           }
           freqArray[i]=count;
           i++;
        }

        i=0;
        j=0;
        while(i< freqArray.length){
            if(freqArray[i]==0){
                i++;
                continue;
            }
            int freq=freqArray[i];
            int k=0;
            while (k<freq){
                arr[j++]=i;
                k++;
            }
            i++;
        }
    }
    public static void countSortStable(int[] arr){  //stable algorithm

        int  max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }

        int[] count=new int[max+1];//frequency array
        for(int i=0;i< arr.length;i++){
            count[arr[i]]=count[arr[i]]+1;
        }

        //making prefix sum array of within count array
        for(int i=1;i<count.length;i++){
            count[i]=count[i]+count[i-1];
        }

//        int [] prefixSumArray=new int[max+1];  //prefix sum array using another array
//        prefixSumArray[0]=count[0];
//        for(int i=1;i< count.length;i++){
//            prefixSumArray[i]=prefixSumArray[i-1]+count[i];
//        }

        int[] ansArray=new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
            int position=count[arr[i]]-1;
            count[arr[i]]--;

            ansArray[position]=arr[i];
        }

        for(int i=0;i< ansArray.length;i++){
            arr[i]=ansArray[i];
        }
    }
    static void printArray(int[] arr){
        for (int val:arr) {
            System.out.print(val+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int[] arr={4,3,1,5,3,1,3,5};
        System.out.println("Array before count sorting ");
        printArray(arr);

        //basicCountSorting(arr);
        countSortStable(arr);
        System.out.println("Array after count sorting");
        printArray(arr);
    }
}

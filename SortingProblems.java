public class SortingProblems {
    static void moveZerosByBubbleSort(int[] arr){
        for(int i=0;i< arr.length-1;i++) {
            for (int j = 0; j < arr.length - 1-i; j++) {
                if (arr[j] == 0 && arr[j+1]!=0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    }
                }
        }
    }
    static void sortFruits(String[] fruits){

        for(int i=0;i<fruits.length;i++){
            int min_index=i;
            for(int j=i+1;j<fruits.length;j++){
                if(fruits[j].compareTo(fruits[min_index])<0){
                    min_index=j;
                }
            }
            String temp=fruits[min_index];
            fruits[min_index]=fruits[i];
            fruits[i]=temp;
        }
    }
    public static void sortA(int[] arr){

        if(arr.length<=1){
            return;
        }
        int maxIdx=0,minIdx=0;
        int i=0;
        for(;i< arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                maxIdx=i;
                minIdx=i+1;
                break;
            }
        }
        for(int j=i+1;j<arr.length-1;j++){
            if(arr[j]>arr[j+1]){
                minIdx=j+1;
                break;
            }
        }
        int temp=arr[minIdx];
        arr[minIdx]=arr[maxIdx];
        arr[maxIdx]=temp;

    }
    public static void negativeFollowedPositiveArray(int[] arr){
        int l=0;
        int r= arr.length-1;
        int pos=-1,neg=-1;
        while(l<r){
            while (l<r){
                if(arr[l]>0){
                    pos=l;
                    l++;
                    break;
                }
                l++;
            }
            while (r>l){
                if(arr[r]<0){
                    neg=r;
                    r--;
                    break;
                }
                r--;
            }
            int temp=arr[pos];
            arr[pos]=arr[neg];
            arr[neg]=temp;
        }
    }

    static void sortZeroOneTwo(int[] arr){

        int[] freqArray=new int[3];
        for(int i=0;i<arr.length;i++){
            freqArray[arr[i]]++;
        }
        int index=0;
        for(int i=0;i<freqArray.length;i++){
            for(int j=0;j<freqArray[i];j++){
                arr[index++]=i;
            }
        }
    }

    public static void sortUsingRegionWise(int[] arr){
        int low=0,mid=0,high=arr.length-1;

        while (mid<=high){
            if(arr[mid]==0){
                int temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low++;
                mid++;
            } else if (arr[mid]==1) {
                mid++;
            }else {
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
    }
    public static void main(String[] args) {

        //Q1.Given an integer array arr,move all zero(0) to the end of it while
        //maintaining the relative order of the non-zero elements
//
//        int[] arr={0,0,5,0,0};
//        moveZerosByBubbleSort(arr);
//        for (int i:arr) {
//            System.out.print(i+" ");
//        }

        //Q2.Given an array of names of the fruits,you are supposed to sort it
        //in lexicographical order using selection sort.

//        String[] fruits={"papaya","mango","apple","kiwi","banana","watermelon","guava"};
//        sortFruits(fruits);
//        for (String val:fruits) {
//            System.out.print(val+" ");
//        }
//
        //Q3.Given an array where all its elements are sorted in increasing order except two swapped-
        //elements ,sort it in linear time.Assume there are no duplicate elements in the array.

      /*  int A[]={3,8,6,7,5,9,10};

        sortA(A);
        System.out.println("Array after sorting");
        for (int val:A) {
            System.out.print(val+" ");
        }

       */

        /*Q4.Given an array of positive and negative integers,segregate them in linear time and
        constant space.The output should print all negative numbers, followed by all positive numbers.
         */

        /*
        int [] inputArray={19,-20,7,-4,-13,11,-5,3};
        negativeFollowedPositiveArray(inputArray);
        System.out.println("array afer sorting");
        for (int val:inputArray) {
            System.out.print(val+" ");
        }

         */

        /* Q5.Given an array of size N containing 0s,1s and 2s ;
        sort the array in ascending order
         */

        int[] unsortedArray={0,2,1,2,0,0,1,2,1,0,1};
        sortZeroOneTwo(unsortedArray);  //myLogicCode
        sortUsingRegionWise(unsortedArray);
        displayArray(unsortedArray);

    }
    public static void displayArray(int [] arr){
        for (int val:arr) {
            System.out.print(val+" ");
        }
        System.out.println();
    }
}

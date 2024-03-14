public class RadixSort {
    static void radixSorting(int arr[] ){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){  //finding maximum number in array
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int tempMax=max;
        int countDigits=0;
        while (tempMax!=0){  //counting no of digits in a max number
            countDigits++;
            tempMax/=10;
        }

        int place=1,place1=1;
        for(int j=0;j<countDigits;j++) {


            int[] count = new int[10];

            for (int i = 0; i < arr.length; i++) {//logic for frequency array
                int last = (arr[i] / place) % 10;
                count[last] += 1;
            }
            place *= 10;
            for (int i = 1; i < count.length; i++) {  //prefix sum array of count array
                count[i] = count[i - 1] + count[i];
            }

            int[] newArr = new int[arr.length];

            for (int i = arr.length - 1; i >= 0; i--) {
                int index = count[(arr[i] / place1) % 10] - 1;
                count[(arr[i]/place1)%10]--;
                newArr[index] = arr[i];
            }
            place1 *= 10;
            for (int i = 0; i < newArr.length; i++) {  //copying newArr to original array arr
                arr[i] = newArr[i];
            }

        }
    }
    public static void main(String[] args) {

        int[] arr={170,45,75,90,802,2};
        radixSorting(arr);

        System.out.println("Array after sorting using radix sort");
        for(int val:arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }

    /*
   // this is a radix sort using count sort

    public static void radixSort(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int max_num=max;
        int countDigit=0;
        while (max!=0){
            countDigit++;
            max/=10;
        }

        for(int i=0,j=1;i<countDigit;i++,j*=10){
            countSortForRadixSort(arr,j);
        }
    }

    public static void countSortForRadixSort(int[] arr,int div) {

        int[] placeArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            placeArray[i] = (arr[i] / div) % 10;
        }
        int[] countArray = new int[10];
        for (int i = 0; i < placeArray.length; i++) {  //frequency array of countArray
            countArray[placeArray[i]]++;
        }
        for (int i = 1; i < countArray.length; i++) { //prefix sum array of countArray
            countArray[i] += countArray[i - 1];
        }

        int ans[] = new int[arr.length];
        for (int i = placeArray.length - 1; i >= 0; i--) {
            int index = countArray[placeArray[i]] - 1;
            ans[index] = arr[i];
            countArray[placeArray[i]]--;
        }

        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }

        */
    }


public class bubble_sort {

    static void bubbleSort(int [] arr){

        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    static void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        int[] num={10,5,50,40,30,20};

       bubbleSort(num);
       printArray(num);
    }
}

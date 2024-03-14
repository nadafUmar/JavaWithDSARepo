import java.util.ArrayList;

public class BucketSort {

    public static void main(String[] args) {

        float [] arr={0.5f,0.4f,0.3f,0.2f,0.1f,0.08f,0.56f};
        System.out.println("Array before bucket sorting");
        displayArray(arr);

        bucketSorting(arr);
        System.out.println("Array after bucket sorting");
        displayArray(arr);
    }
    static void bucketSorting(float[] arr){

        ArrayList<Float>[] bucket=new ArrayList[6];  //array of arraylist
        for(int i=0;i<6;i++){ //initializing arraylist
            bucket[i]=new ArrayList<>();
        }

        for(int i=0;i< arr.length;i++){   //scattering array elements into buckets
            int pattern= (int) (arr[i]*10);
            bucket[pattern].add(arr[i]);
        }

        for(int i=0;i< bucket.length;i++){ //no of rows(no of bucket)
            //you can sort using any other sorting algorithms
           for(int l=0;l<bucket[i].size()-1;l++) {  //here I have been using bubble sort to sort each bucket
               for (int j = 0; j < bucket[i].size() - 1-l; j++) {
                   if (bucket[i].get(j) > bucket[i].get(j + 1)) {
                       float temp = bucket[i].get(j);
                       bucket[i].set(j, bucket[i].get(j + 1));
                       bucket[i].set(j + 1, temp);
                   }
               }
           }
        }

        int k=0;
        for(int i=0;i<bucket.length;i++){  //gathering all elements present in each bucket
            for(int j=0;j<bucket[i].size();j++){
                arr[k++]=bucket[i].get(j);
            }
        }
    }
    public static void displayArray(float[] arr){
        for(float val:arr){
            System.out.print(val+"  ");
        }
        System.out.println();
    }
}

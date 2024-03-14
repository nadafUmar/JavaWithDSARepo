public class BinarySearch {

    static boolean binarySearchIterative(int[] arr,int target){
        int st=0,end=arr.length-1;

        //binary search using iterative approach
        while (st<=end){
            int mid=(st+end)/2;

            if(target==arr[mid]){
                return true;
            } else if (target<arr[mid]) {
                end=mid-1;
            }else {
                st=mid+1;
            }
        }
        return false;
    }
    static boolean binarySearchRecursive(int[] arr,int st,int end,int target){
        if(st>end) return false;
        int mid=(st+end)/2;

        if(target==arr[mid]){
            return true;
        }else if(target<arr[mid]){
            return binarySearchRecursive(arr,st,mid-1,target);
        }else {
            return binarySearchRecursive(arr,mid+1,end,target);
        }
    }
    public static void main(String[] args) {

        int[] arr={10,20,30,40,50,60,70,80,90};
        int target=10;

        while (target!=150){
            System.out.printf("%d exists :%b \n",target,binarySearchIterative(arr,target));
            System.out.printf("%d exists :%b \n",target,binarySearchRecursive(arr,0,arr.length-1,target));
            System.out.println();
            target+=10;
        }
    }
}

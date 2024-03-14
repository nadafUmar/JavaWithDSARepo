public class BinarySearch_problems {

    static int firstOccurrences(int[] arr,int x) {

        //this is my logic for this questions
        int st=0,end= arr.length-1;
        int index=-1;

        while (st<=end){
            int mid=st+(end-st)/2;

            if(x==arr[mid]){
                index=mid;
                break;
            } else if (x<arr[mid]) {
                end=mid-1;
            }else {
                st=mid+1;
            }
        }

        if(index==-1){
            return -1;
        }
        while (true){
            if(x!=arr[--index]){
                return index+1;
            }
        }
    }

    static int firstOccur(int[] arr,int x){

        int st=0,end= arr.length-1;
        int index=-1;

        while (st<=end){
            int mid=st+(end-st)/2;

            if(x==arr[mid]){
                index=mid;
                end=mid-1;
            } else if (x<arr[mid]) {
                end=mid-1;
            }else {
                st=mid+1;
            }
        }
        return index;
    }

    static int squareRoot(int x){
        int st=0,end=x;
        int ans=-1;

        while (st<=end){
            int mid=st+(end-st)/2;
            int val=mid*mid;

            if(val==x) return mid;
            else if (val<x) {
                st=mid+1;
                ans=mid;
            }else {
                end=mid-1;
            }
        }
        return ans;
    }

    public static int minIndexInRotatedSortedArr(int[] arr){
        int n=arr.length;
        int st=0,end=n-1;

        while (st<=end){
            int mid=st+(end-st)/2;

            if(arr[mid]>arr[n-1]){
                st=mid+1;
            } else if (arr[mid]<=arr[n-1] && arr[mid]<arr[mid-1]) {
                return mid;
            }else{
                end=mid-1;
            }
        }

        return -1;
    }

    static int indexOfTarget(int[] arr,int target){

        int n=arr.length;
        int st=0,end=n-1;

        while(st<=end){
            int mid=st+(end-st)/2;

            if(target==arr[mid]){
                return mid;
            } else if (arr[mid]<arr[end]){
                if(target>arr[mid] && target<=arr[end]){
                    st=mid+1;
                }else{
                    end=mid-1;
                }
            }else {
               if(target>=arr[st] && target<arr[mid]){
                   end=mid-1;
               }else{
                   st=mid+1;
               }
            }
        }
        return -1;
    }

    public static boolean isTargetFound(int[] arr,int target){

        int n=arr.length;
        int st=0,end=n-1;

        while(st<=end){
            int mid=st+(end-st)/2;

            if(target==arr[mid]){
                return true;
            } else if (arr[st]==arr[mid] && arr[end]==arr[mid]) {
                st++;
                end--;
            } else if (arr[mid]<=arr[end]){
                if(target>arr[mid] && target<=arr[end]){
                    st=mid+1;
                }else{
                    end=mid-1;
                }
            }else {
                if(target>=arr[st] && target<arr[mid]){
                    end=mid-1;
                }else{
                    st=mid+1;
                }
            }
        }
        return false;
    }

    static boolean binarySearch2D(int[][] matrix,int target){

        int rows=matrix.length;  //no of rows
        int cols=matrix[0].length;  //no of columns

        int n=rows*cols;
        int st=0,end=n-1;

        while(st<=end){
            int mid=st+(end-st)/2;
            int r=mid/cols,c=mid%cols;

            if(target==matrix[r][c]){
                return true;
            } else if (target<matrix[r][c]) {
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
        return false;
    }

    public static boolean isFoundTargetInRowColumnsSortedMatrix(int[][] matrix,int target){

        int rows=matrix.length;
        int cols=matrix[0].length;

        int i=0,j=cols-1;  //this is pointer

        while(i<rows && j>=0){
            if(target==matrix[i][j]){
                return true;
            } else if (target<matrix[i][j]) {
                j--;  //move columns to left
            }else{
                i++;  //move rows to bottom
            }
        }
        return false;
    }

    public static int findPeakIndex(int[] arr){

        int st=0,end=arr.length-1;

        int index=-1;
        while (st<=end){
            int mid=st+(end-st)/2;

            if(arr[mid]<arr[mid+1]){
                index=mid+1;
                st=mid+1;
            }else {
                end=mid-1;
            }
        }
        return index;
    }

    public static int peakIndex(int[] arr){
        int n=arr.length;

        int st=0,end=n-1;

        while(st<=end){
            int mid=st+(end-st)/2;
            if((mid==n-1||arr[mid]>arr[mid+1] )&& (mid==0||arr[mid]>arr[mid-1])){
                return mid;
            } else if (arr[mid]<arr[mid+1]) {
                st=mid+1;
            }else {
                end=mid-1;
            }
        }
        return -1;
    }
    public static int choclateDistribution(int[] arr,int m){
       if(arr.length<m) return -1;

       int ans=0,st=1,end=(int)1e9;
       while (st<=end){
           int mid=st+(end-st)/2;
           if(isDivisionPOssible(arr,m,mid)){
               ans=mid;
               end=mid-1;
           }else{
               st=mid+1;
           }
       }
       return ans;
    }
    static boolean isDivisionPOssible(int[] arr,int m,int maxChocAllowed){
        int noOfStudents=1;
        int choc=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxChocAllowed) return false;
            if(choc+arr[i]<=maxChocAllowed){
                choc+=arr[i];
            }else {
                noOfStudents++;
                choc=arr[i];
            }
        }
        return noOfStudents<=m;
    }

    public static int raceTrack(int[] arr,int k){
        if(k> arr.length) return -1;
        int st=1,end=(int)1e9;
        int ans=-1;

        while(st<=end){
            int mid=st+(end-st)/2;
            if(isPossible(arr,k,mid)){
                ans=mid;
                st=mid+1;
            }else {
                end=mid-1;
            }
        }
        return ans;
    }
    static boolean isPossible(int[] arr,int k,int dist){
        int kidsPlaced=1;
        int lastKid=arr[0];

        for(int i=1;i< arr.length;i++){
            if(arr[i]-lastKid>=dist){
                kidsPlaced++;
                lastKid=arr[i];
            }
        }
        return kidsPlaced>=k;
    }
    public static void main(String[] args) {

        /*Q1.Find the first occurrences of a given element x.
          Given that the given array is sorted.if no occurrences of x is found
          then return -1.
         */

//        int[] arr={2,5,5,5,6,6,8,9,9,9};
//        int x=65;
//        System.out.println(firstOccurrences(arr,x));
//        System.out.println(firstOccur(arr,x));


        /*
         Q.2 Find the square root of the given non-negative x.
         round it off to the nearest floor integer value;
         */

       // int x=150;
       // System.out.println(squareRoot(x));


        /*
        //Q.3 A rotated sorted Array is a sorted Array on which rotation operations has been
        performed some number of times.Given a rotated sorted array ,find the index of the minimum
        element in the array .follow 0-based indexing .it is guaranteed that all the elements
        in the array is unique.
         */

        //int[] arr={3,4,5,6,7,8,1,2};
        //System.out.println(minIndexInRotatedSortedArr(arr));

        /*
        Q.4 Given the rotated sorted array of integers,which contains distinct elements,and
        an integer target,return the index of target if it is in array.otherwise return -1;
         */

      //  int[] arr={5,6,7,8,9,1,2,3,4};

       // System.out.println(indexOfTarget(arr,4));

        /*
        Q5. search elements in rotated sorted array with duplicate elements .return true
        if the elements is found else return false;
         */

        //int[] a={1,1,1,1,1,1,2,3,1,1};
       // int target=2;
      //  System.out.println(isTargetFound(a,target));

        /*
        Q6.Search the target value in a 2D integer matrix of dimensions n*m and return true
        if found else return false.
        the matrix has the following properties
        1.integers in each row are sorted from left to right
        2.the first integer of each row is greater than the last integer of the previous row
         */

       // int [][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        //System.out.println(binarySearch2D(matrix,60));

        /*
        Q.7 write an efficient algorithm that searches for a value target in an M*N integer matrix.this matrix has the following properties
        1.integer in each row are sorted in ascending order from left to right
        2.integer in each column are sorted in ascending order from top to bottom
         */

      //  int [][] matrix={{2,4,6,8},{5,6,7,20},{7,11,13,25},{12,14,17,30}};
       // System.out.println(isFoundTargetInRowColumnsSortedMatrix(matrix,15));

        /*
        Q.8 Given a mountain array 'a' of length greater than or equal to 3,return the index i ,
        such that a[0]<a[1]<a[i-1]<a[i]>a[i+1]>a[i+2]>..... a[arr.length-1].this is known as peak index;
         */
       // int [] a={0,4,5,6,1,0,7,8,9,3,2,1};
      //  System.out.println(findPeakIndex(a));

        /*
        Q.9 A peak element is an element that is strictly greater than its neighbours.
        Given a 0-based index integer array nums,find a peak element and return its index,if
        the array contains multiple peak elements ,return the index to any of the peaks;
         */

      //  int[] nums={2,3,4,5,8,4,3,2,9,10,11,12,10,9,6};
      //  System.out.println(peakIndex(nums));

        //Q10-for questions go to note copy

      // int[] chocBoxes={8,4,6,2};
      //  int no_of_students=2;
      //  System.out.println(choclateDistribution(chocBoxes,no_of_students));

        //Q11-for questions go to note copy
        int[] startPoint={1,2,4,8,9};
        int no_of_kids=3;
        System.out.println(raceTrack(startPoint, no_of_kids));

        int x=(int)1e9;
        System.out.println(x);
        System.out.println(Integer.MAX_VALUE);


    }
}

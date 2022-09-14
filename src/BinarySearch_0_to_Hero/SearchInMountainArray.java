package BinarySearch_0_to_Hero;
//leetcode.com/problems/find-in-mountain-array/
public class SearchInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        int target=3;
int ans=search(arr,target);
        System.out.println(ans);

    }

     static int search(int[] arr, int target) {
        int peak=findPeak(arr);
        int ans=orderAgnostic(arr,target,0,peak);
       if(ans!=-1)
           return ans;
       else
           return orderAgnostic(arr,target,peak+1,arr.length-1);

    }

     static int findPeak(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]) end=mid;
            else start=mid+1;
        }
        return start;
    }

    static int orderAgnostic(int[] arr, int target,int start,int end) {
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (target == arr[mid]) return mid;
            if (isAscending) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }


}

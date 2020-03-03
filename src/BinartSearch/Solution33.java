package BinartSearch;

public class Solution33 {
    public static int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int left = 0;
        int right = nums.length-1;

        while (left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]<nums[right]){
                if(target<=nums[mid]||target>nums[right]){right = mid;}
                else left=mid+1;

            }
            else if(nums[mid]>=nums[left]){
                if(target>nums[mid]||target<nums[left]){left = mid+1;}
                else right=mid;
            }

        }

        return nums[left]==target?left:-1;
    }

    public static void main(String[] args) {
        int[] num = {1,4};
        System.out.println(search(num,0));
    }
}

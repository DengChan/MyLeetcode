package BinartSearch;

import java.util.Arrays;

public class Solution287 {
    public static int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        Arrays.sort(nums);
        // 即寻找第一个nums[mid]<
        while (left<right){
            int mid = left+(right-left+1)/2;
            if(nums[mid]<=mid+1){
                right = mid-1;
            }
            else {
                left=mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,6,7};
        System.out.println(findDuplicate(nums));
    }
}

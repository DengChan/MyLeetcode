package Offer;

public class Leetcode287 {
    public int findDuplicate(int[] nums) {
        if (nums==null) return 0;
        if(nums.length<=1) return 0;
        int left =1;
        int right = nums.length;
        while (left<right){
            int mid=left + (right-left)/2;
            int cnt = count(nums, mid);
            if(cnt<=mid) left = mid+1;
            else right = mid;
        }
        return nums[left];

    }
    private int count(int[] nums, int target){
        int cnt = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<=target) cnt+=1;
        }
        return cnt;
    }
}

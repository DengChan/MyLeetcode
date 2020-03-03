package BinartSearch;

public class Solution34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if (nums.length==0) {
            return res;
        }
        int left = 0;
        int right = nums.length-1;
        // 求第一个等于目标值的位置
        while (left<right){
            int mid = left + (right-left)/2;
            // 如果mid小于目标值 那么第一个比目标值小的数一定在右侧,不包括mid
            if(nums[mid]<target){
                left = mid +1;
            }
            // 大于等于目标值， 可能在mid或mid左侧
            else {
                right = mid;
            }
        }
        // 假如不存在target 那么最后夹逼的结果会是第一个大于目标值的元素 所以这里需要判断一下
        if(nums[left]!=target){
            return res;
        }
        else {
            res[0]=left;
        }


        // 求最后一个等于目标值的位置
        left = 0;
        right = nums.length-1;
        while (left<right){
            int mid = left + (right-left+1)/2;
            // 如果mid大于目标值 那么所求元素一定在mid左侧
            if(nums[mid]>target){
                right = mid-1;
            }
            // 如果mid小于等于目标值， 那么所求元素可能在mid或mid右侧
            else {
                left = mid;
            }

        }
        // 元素一定存在，不需要特判
        res[1]= left;
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 10;
        int[] res = searchRange(nums,target);

        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}

package BinartSearch;

public class Solution35 {
    public static int searchInsert(int[] nums, int target) {
        if(nums.length==0) return 0;
        int left = 0;
        int right = nums.length;
        while (left<right){
            int mid = left + (right-left)/2;
            // 如果mid 小于target ,mid及mid左侧一定不是
            if(nums[mid]<target){
                left = mid+1;
            }
            // 如果 mid 大于等于target, mid或mid左侧可能是,但右侧一定不是
            else {
                right = mid;
            }
        }
        // 因为在变化的是左边界，而右边界包含了mid,
        // 最后边界会收缩到右边界的分支,即target的索引(找到了)或第一个>target的索引（没找到）
        // 而没找到时，这个索引刚好是应该插入的位置
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,11));
    }
}

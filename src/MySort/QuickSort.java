package MySort;

import java.util.Random;

public class QuickSort {
    public void quickSort(int[] nums, int start, int end) throws Exception {
        if(nums==null) throw new Exception("空指针");
        if(nums.length==0||end<start|| start<0||end>=nums.length) throw new Exception("下标越界");

        if (start==end) return;

        int index = partition(nums, start, end);

        if(index>start)
            quickSort(nums, start,index-1);

        if(index<end)
            quickSort(nums, index+1, end);
    }

    public int partition(int[] nums, int start, int end){
        // 随机选择一个数 放在末尾 选择这个数作为pivot
        Random random = new Random();
        int index = random.nextInt(end-start+1) + start;
        swap(nums, index, end);

        int small_board = start-1; // j 始终指向小于pivot的数字的区间的最右侧
        for(int i =start; i<end;i++){
            if(nums[i]<nums[end]){
                small_board++;
                // 只有新边界不等于游标i 的时候才交换，减少不必要的交换
                if(small_board!=i) swap(nums, i, small_board);
            }
        }

        ++small_board;
        swap(nums, small_board, end);
        return small_board;
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

//    public static void main(String[] args) throws Exception {
//        int[] nums = {1,2,3};
//        quickSort(nums,0, nums.length-1);
//        for(int k: nums) System.out.print(k + "\t");
//    }
}

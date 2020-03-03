package Offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution03 {

    StringBuffer sb  = new StringBuffer();

    public int findRepeatNumber(int[] nums) {
        int a = 0;
        
        for(int i=0;i<nums.length;i++){
            while (i!=nums[nums[i]]){
                if(nums[nums[i]]==nums[i]) return nums[i];
                swap(nums, i,nums[i]);
            }
        }
        return -1;

    }
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}
